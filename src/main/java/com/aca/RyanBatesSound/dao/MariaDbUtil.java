package com.aca.RyanBatesSound.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




public class MariaDbUtil {

	private static String connectionUrl = 
			"jdbc:mysql://aws.connect.psdb.cloud?user=4f9uh2pyirhted8w97bb&password=pscale_pw_miOLyGEkrKWSRZbWoLsgXYID9nxJLwXvR5IBSMS4Q6g";
	
    public static Connection getConnection() {
        Connection connection = null;
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(connectionUrl);
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


        
    
    		
