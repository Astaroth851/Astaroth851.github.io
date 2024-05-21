package com.aca.RyanBatesSound.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import io.github.cdimascio.dotenv.Dotenv;

public class MariaDbUtil {

    private static String connectionUrl = "jdbc:mysql://";

    public static Connection getConnection() {
        // Assuming the .env file is at the root of the project directory
        Dotenv dotenv = Dotenv.configure().directory("./").load();

        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbHost = "sql5.freemysqlhosting.net";
            String dbUsername = "sql5708143";
            String dbPassword = "SmfN9ibQMa";
            String dbName = "sql5708143";
            String urlWithDatabase = connectionUrl + dbHost + "/" + dbName + "?useSSL=false&serverTimezone=UTC";

            System.out.println("urlWithDataBase");

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
