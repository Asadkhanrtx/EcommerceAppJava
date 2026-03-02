package com.conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

    private static Connection conn = null;

    public static Connection getConn() {

        try {

            // load SQLite driver
            Class.forName("org.sqlite.JDBC");

            // correct path inside Docker container
            conn = DriverManager.getConnection(
                "jdbc:sqlite:/usr/local/tomcat/webapps/mydatabase.db"
            );

        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }
}
