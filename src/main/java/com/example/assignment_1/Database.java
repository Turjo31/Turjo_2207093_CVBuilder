package com.example.assignment_1;

import java.sql.*;

public class Database {

    private static final String DB_URL = "jdbc:sqlite:cv_data.db";


    public static Connection connect()
    {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
        return conn;
    }

    public static void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS cv_table (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "email TEXT," +
                "phone TEXT," +
                "address TEXT," +
                "skills TEXT," +
                "experience TEXT," +
                "education TEXT," +
                "projects TEXT" +
                ");";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Table creation failed: " + e.getMessage());
        }
    }

    public static void insertCV(String name, String email, String phone, String address,
                                String skills, String experience, String education, String projects) {

        String sql = "INSERT INTO cv_table(name, email, phone, address, skills, experience, education, projects) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, phone);
            pstmt.setString(4, address);
            pstmt.setString(5, skills);
            pstmt.setString(6, experience);
            pstmt.setString(7, education);
            pstmt.setString(8, projects);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Insert failed: " + e.getMessage());
        }
    }
}
