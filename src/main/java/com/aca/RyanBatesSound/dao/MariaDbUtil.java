package com.aca.RyanBatesSound.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.File;
import io.github.cdimascio.dotenv.Dotenv;



public class MariaDbUtil {

	private static String connectionUrl = 
			"jdbc:mysql://";
	
    public static Connection getConnection() {
    	 Dotenv dotenv = Dotenv.configure().directory(new File(".env").getAbsolutePath()).load();
   	  
    	Connection connection = null;
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	//  String dbHost = System.getenv("DATABASE_HOST");
          //  String dbUsername = System.getenv("DATABASE_USERNAME");
           // String dbPassword = System.getenv("DATABASE_PASSWORD");
        	String dbHost = dotenv.get("DATABASE_HOST");
            String dbUsername = dotenv.get("DATABASE_USERNAME");
            String dbPassword = dotenv.get("DATABASE_PASSWORD");
             String urlWithCredentials = connectionUrl + dbHost + "?user=" + dbUsername + "&password=" + dbPassword;
                       
             Properties props = new Properties();
             props.setProperty("user", dbUsername);
             props.setProperty("password", dbPassword);
             props.setProperty("useSSL", "true"); // Enable SSL

			connection = DriverManager.getConnection(urlWithCredentials,props);
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


        
    
    	
    
    		
