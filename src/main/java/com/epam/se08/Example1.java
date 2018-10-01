package com.epam.se08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

public class Example1 {

    public static void main(String[] args) throws SQLException, IOException {
        Properties props = new Properties();
        props.load(Example1.class.getResourceAsStream("db.properties"));

        int id = Integer.parseInt(args[0]);
        String name = args[1];
        String surName = args[2];
        int groupId = Integer.parseInt(args[3]);

        try (Connection connection = DriverManager.getConnection(props.getProperty("db"), props)) {
            System.out.println("Connection opened: " + !connection.isClosed());

            try (Statement statement = connection.createStatement()) {
//                updateDepartment(statement);
//                selectFromDepartments(statement);
                int updatedRows = statement.executeUpdate("INSERT INTO UNIVERSITY.STUDENTS (ID, LAST_NAME, FIRST_NAME, GROUP_ID) VALUES ("
                        + id + ","
                        + "'" + name + "',"
                        + "'" + surName + "',"
                        + groupId +
                        ")");
                System.out.println(updatedRows);

            }
        }
    }

    private static void selectFromDepartments(Statement statement) throws SQLException {
        try (ResultSet result = statement.executeQuery("SELECT ID, NAME, ACRONYM FROM UNIVERSITY.DEPARTMENTS")) {
            while (result.next()) {
                System.out.println(result.getInt("ID"));
                System.out.println(result.getString("NAME"));
                System.out.println(result.getString("ACRONYM"));
                System.out.println("-----");
            }
        }
    }

    private static void updateDepartment(Statement statement) throws SQLException {
        int updatedEntities = statement.executeUpdate("UPDATE UNIVERSITY.DEPARTMENTS SET NAME='Факультет электроники (updated)' WHERE ID=1");
        System.out.println(updatedEntities);
    }

    private static void howToUseResources() throws IOException {
        //        InputStream sqlFileInputStream = Example1.class.getResourceAsStream("./../../../1.sql");
        InputStream sqlFileInputStream = Example1.class.getResourceAsStream("/1.sql");
        String sql = new BufferedReader(new InputStreamReader(sqlFileInputStream)).readLine();
        System.out.println(sql);
    }
}
