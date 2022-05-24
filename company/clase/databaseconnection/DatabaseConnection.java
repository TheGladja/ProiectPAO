package com.company.clase.databaseconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/proiectpao";
    private static final String USER = "root";
    private static final String PASSWORD = "Napoleonwar123";

    private static Connection databaseConnection;

    private DatabaseConnection() {}

    public static Connection getDatabaseConnection() {
        try {
            if(databaseConnection == null || databaseConnection.isClosed())
            {
                try {
                    databaseConnection = DriverManager.getConnection(DB_URL,USER, PASSWORD);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return databaseConnection;
    }

    public static void closeDatabaseConfiguration() {
        try {
            if(databaseConnection != null || !databaseConnection.isClosed())
            {
                try {
                    databaseConnection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
