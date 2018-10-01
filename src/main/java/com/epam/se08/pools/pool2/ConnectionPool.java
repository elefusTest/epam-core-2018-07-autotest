package com.epam.se08.pools.pool2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class ConnectionPool {

    private static final String PROPERTIES_FILE = "properties/database";
    private static final int DEFAULT_POOL_SIZE = 10;
    private static ConnectionPool instance;
    private BlockingQueue<Connection> connectionQueue;

    public static synchronized void init() throws SQLException {
        if (instance == null) {
            ResourceBundle rb = ResourceBundle.getBundle(PROPERTIES_FILE);
            String url = rb.getString("db.url");
            String user = rb.getString("db.user");
            String password = rb.getString("db.password");
            int poolSize = Integer.parseInt(rb.getString("db.poolsize"));
            try {
                instance = new ConnectionPool(url, user, password, poolSize);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static ConnectionPool getInstance() {
        return instance;
    }

    public static void dispose() throws SQLException {
        if (instance != null) {
            instance.clearConnectionQueue();
            instance = null;
        }
    }

    private ConnectionPool(String url, String user, String password, int poolSize) throws ClassNotFoundException, SQLException {
        connectionQueue = new ArrayBlockingQueue<>(poolSize);
        for (int i = 0; i < poolSize; i++) {
            connectionQueue.add(DriverManager.getConnection(url, user, password));
        }
    }

    public Connection takeConnection() {
        try {
            return connectionQueue.poll(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void releaseConnection(Connection connection) {
        try {
            if (!connection.isClosed()) {
                if (!connectionQueue.offer(connection)) {
                    //"Connection not added. Possible `leakage` of
                    // connections"
                }
            } else {
                //"Trying to release closed connection. Possible
                // `leakage` of connections"
            }
        } catch (SQLException e) {
            //"SQLException at conection isClosed () checking.
            // Connection not added", e
        }
    }

    private void clearConnectionQueue() throws SQLException {
        Connection connection;
        while ((connection = connectionQueue.poll()) != null) {
            /* see java.sql.Connection#close () javadoc */
            if (!connection.getAutoCommit()) {
                connection.commit();
            }
            connection.close();
        }
    }


    public void execute(Consumer<Connection> action) {

    }
}
