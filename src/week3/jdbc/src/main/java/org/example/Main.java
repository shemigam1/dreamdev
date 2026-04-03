package org.example;

import java.sql.*;

public class Main {
    public static void main(String... args) {
        String url = "jdbc:mysql://localhost/books_db";
        String username = "semil";
        String password = "$Aerospace03";
//        String sql = """
//                insert into books(id, title, author)
//                values (15, 'Java how to program', 'paul and harvey dietel');
//                """;
        String title = "head first java";
        String author = "teslim";
        String sql = """
                insert into books(id, title, author)
                values (13, ?, ?);
                """;


        /*
        *executeQuery(); select only
        * executeUpdate() insert, update, delete
        * execute() any sql command
        *
         */
        try{

        Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println(conn.isValid(4));
            Statement statement = conn.createStatement();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, title);
            stmt.setString(2, author);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
