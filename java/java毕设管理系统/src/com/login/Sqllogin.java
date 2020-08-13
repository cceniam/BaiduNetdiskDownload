package com.login;
import java.sql.*;
public class Sqllogin {
    public static void lodingDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Success loading Mysql Driver!");
        }
        catch (Exception e) {
            System.out.print("Error loading Mysql Driver!");
            e.printStackTrace();
        }
    }

    public static Connection loginSql(String DBName) {
        try {
            System.out.println("jdbc:mysql://localhost:3306/".concat(DBName));
            Connection connect = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/".concat(DBName).concat("?characterEncoding=utf8&useSSL=false"), "root", "YUzhe83952");
            if (connect != null) {
                System.out.println("Success connect Mysql server!");
            }
            return connect;
        } catch (Exception e) {
            System.out.print("get data error!");
            e.printStackTrace();
        }

        return null;
    }
}
