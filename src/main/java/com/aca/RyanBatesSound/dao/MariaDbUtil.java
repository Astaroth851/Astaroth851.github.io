package com.aca.RyanBatesSound.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class MariaDbUtil {

	private static String connectionUrl = 
			"jdbc:mongodb://atlas-sql-6579308135cbe34439fefa5f-drchd.a.query.mongodb.net/SoundMovies?ssl=true&authSource=admin";
	
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://aws.connect.psdb.cloud/soundmovies?sslMode=VERIFY_IDENTITY",
 	 "9b9a17nrr8z3vzhd72ec",
  	"************");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return connection;
	}
	
	public static void main (String[] args) throws SQLException {
		Connection connection = MariaDbUtil.getConnection();
		if (null != connection) {
			System.out.println("A real connection");
		
		} else 
			
			System.out.println("Help. Connection is null.");
		}

	}

