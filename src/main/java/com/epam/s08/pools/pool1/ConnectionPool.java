package com.epam.s08.pools.pool1;

import lombok.Setter;
import lombok.experimental.Delegate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class ConnectionPool {

    private static final ConnectionPool INSTANCE = new ConnectionPool();

    private List<PooledConnection> freeConnections;

    @Setter
    private String driverClassName;

    @Setter
    private String url;

    @Setter
    private String username;

    @Setter
    private String password;

    @Setter
    private Integer connectionNumber;

    private Semaphore semaphore;

    private ConnectionPool() {}

    public void initConnections() throws SQLException {
        semaphore = new Semaphore(connectionNumber);
        freeConnections = new LinkedList<>();
        for (int i = 0; i < connectionNumber; i++) {
            freeConnections.add(new PooledConnection(DriverManager.getConnection(url, username, password)));
        }
    }

    public static ConnectionPool getInstance() {
        return INSTANCE;
    }

    public Connection getConnection() {
        try {
            semaphore.acquire();
            return freeConnections.remove(0);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void closeConnections() {
        int releaseNumber = connectionNumber - semaphore.availablePermits();
        semaphore.release(releaseNumber);
    }

    private class PooledConnection implements Connection {

        @Delegate(excludes = AutoCloseable.class)
        private Connection connection;

        public PooledConnection(Connection c) throws SQLException {
            this.connection = c;
            this.connection.setAutoCommit(true);
        }

        @Override
        public void close() throws SQLException {
            if (connection.isReadOnly()) {
                connection.setReadOnly(false);
            }
            freeConnections.add(this);
            semaphore.release();
        }
    }
}

