package com.aca.RyanBatesSound.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




public class MariaDbUtil {

	private static String connectionUrl = 
			"jdbc:mysql://";
	
    public static Connection getConnection() {
        Connection connection = null;
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	 String dbHost = System.getenv("DATABASE_HOST");
             String dbUsername = System.getenv("DATABASE_USERNAME");
             String dbPassword = System.getenv("DATABASE_PASSWORD");
             String dbName = System.getenv("DATABASE");
             String urlWithCredentials = connectionUrl + dbHost + "?user=" + dbUsername + "&password=" + dbPassword;

			connection = DriverManager.getConnection(urlWithCredentials);
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
        } catch (SQLException e) {
            // Print the exception for diagnosis
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {
    	Connection connection = MariaDbUtil.getConnection();
		if (null != connection) {
			System.out.println("A real connection");
		} else 
			System.out.println("Help. Connection is null.");
		}
        
    }


        
    
    		
