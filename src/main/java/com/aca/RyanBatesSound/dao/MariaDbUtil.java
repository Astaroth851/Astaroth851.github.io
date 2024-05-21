package com.aca.RyanBatesSound.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import io.github.cdimascio.dotenv.Dotenv;

public class MariaDbUtil {

    private static String connectionUrl = "jdbc:mysql://";

    public static Connection getConnection() {
        Dotenv dotenv = Dotenv.configure().directory("C:\\Users\\Astar\\OneDrive\\eclipse-workspace\\RyanBatesSound").load();

        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbHost = process.env.DATABASE_HOST;
            String dbUsername = process.env.DATABASE_USERNAME;
            String dbPassword = process.env.DATABASE_PASSWORD;
            String dbName = process.env.DATABASE_NAME;
            String urlWithDatabase = connectionUrl + dbHost + "/" + dbName + "?useSSL=false&serverTimezone=UTC";

            Properties props = new Properties();
            props.setProperty("user", dbUsername);
            props.setProperty("password", dbPassword);

            connection = DriverManager.getConnection(urlWithDatabase, props);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {
        Connection connection = MariaDbUtil.getConnection();
        if (connection != null) {
            System.out.println("A real connection");
        } else {
            System.out.println("Help. Connection is null.");
        }
    }
}
        
    
    		
    
    	
    
    		
