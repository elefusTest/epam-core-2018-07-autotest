package com.epam.s08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

public class Example1 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
//        Class<?> clazz = Class.forName("org.h2.Driver");

        Properties props = new Properties();
        props.load(Example1.class.getResourceAsStream("db.properties"));

        try (Connection connection = DriverManager.getConnection(props.getProperty("db"), props)) {
            System.out.println("Connection opened: " + !connection.isClosed());

            try (Statement statement = connection.createStatement()) {
                int updatedEntities = statement.executeUpdate("UPDATE UNIVERSITY.DEPARTMENTS SET NAME='Факультет электроники (updated)' WHERE ID=1");
                System.out.println(updatedEntities);

                try (ResultSet result = statement.executeQuery("SELECT ID, NAME, ACRONYM FROM UNIVERSITY.DEPARTMENTS")) {
                    while (result.next()) {
                        System.out.println(result.getInt("ID"));
                        System.out.println(result.getString("NAME"));
                        System.out.println(result.getString("ACRONYM"));
                        System.out.println("-----");
                    }
                }
            }
        }
    }

    private static void howToUseResources() throws IOException {
        //        InputStream sqlFileInputStream = Example1.class.getResourceAsStream("./../../../1.sql");
        InputStream sqlFileInputStream = Example1.class.getResourceAsStream("/1.sql");
        String sql = new BufferedReader(new InputStreamReader(sqlFileInputStream)).readLine();
        System.out.println(sql);
    }
}
