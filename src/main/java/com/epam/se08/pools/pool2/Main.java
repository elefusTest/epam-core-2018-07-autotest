package com.epam.se08.pools.pool2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        ConnectionPool pool = ConnectionPool.getInstance();

        pool.execute(connection -> {
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery("SELECT * FROM STUDENTS")) {
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getInt(3));
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
}
