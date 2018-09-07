package com.epam.s08.pools.pool3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConnectionPool {

    private static ConnectionPool instance;

    private ArrayList<Connection> freeConnections = new ArrayList<>();

    private String URL;
    private String user;
    private String password;
    private int maxConn;

    private ConnectionPool(String URL, String user, String password, int maxConn) {
        this.URL = URL;
        this.user = user;
        this.password = password;
        this.maxConn = maxConn;
    }

    public static synchronized ConnectionPool getInstance(String URL, String user, String password, int maxConn) {
        if (instance == null) {
            instance = new ConnectionPool(URL, user, password, maxConn);
        }
        return instance;
    }

    public synchronized Connection getConnection() {
        if (freeConnections.isEmpty()) {
            return newConnection();
        } else {
            try {
                Connection connection = freeConnections.remove(freeConnections.size() - 1);
                if (connection.isClosed()) {
                    return getConnection();
                } else {
                    return connection;
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    private Connection newConnection() {
        try {
            if (user == null) {
                return DriverManager.getConnection(URL);
            } else {
                return DriverManager.getConnection(URL, user, password);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public synchronized void freeConnection(Connection con) {
        // Put the connection at the end of the List
        if ((con != null) && (freeConnections.size() <= maxConn)) {
            freeConnections.add(con);
        }
    }

    public synchronized void release() {
        for (Connection con : freeConnections) {
            try {
                con.close();
                // "Closed connection for pool „
            } catch (SQLException e) {
                // "Can't close connection for pool „
            }
        }
        freeConnections.clear();
    }
}
