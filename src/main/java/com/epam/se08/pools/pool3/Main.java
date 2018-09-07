package com.epam.se08.pools.pool3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        ConnectionPool pool = ConnectionPool.getInstance("jdbc:mysql://127.0.0.1/test", "root", "123456", 5);
        Connection con = pool.getConnection();
        try {
            try (Statement statement = con.createStatement();
                 ResultSet resultSet = statement.executeQuery("SELECT * FROM STUDENTS")) {
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getInt(3));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            pool.freeConnection(con);
        }

        // TODO ...

        pool.release();
    }
}

