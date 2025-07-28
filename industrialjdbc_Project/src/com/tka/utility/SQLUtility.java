package com.tka.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLUtility {
	
	public static Connection connection = null;
	public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String path = "com.mysql.cj.jdbc.Driver";
	public static final String url = "jdbc:mysql://localhost:3306/advjava226db";
	public static final String username = "root";
	public static final String password = "root";
	
	public static Connection getConnection() {
        
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

}
