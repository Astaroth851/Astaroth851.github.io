package com.aca.RyanBatesSound.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthenticationDao {
	
			public String authenticateUserAndRetrieveRole(String username, String password) {
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;
	        String role = null;

	        try {
	            // Get a connection to the database
	            connection = MariaDbUtil.getConnection();

	            // Prepare SQL query to check user credentials and retrieve role
	            String query = "SELECT role FROM users WHERE username = ? AND password = ?";
	            preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setString(1, username);
	            preparedStatement.setString(2, password);

	            // Execute the query
	            resultSet = preparedStatement.executeQuery();

	            // If a row is returned, credentials are valid, retrieve the role
	            if (resultSet.next()) {
	                role = resultSet.getString("role");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            // Close the resources
	            try {
	                if (resultSet != null) resultSet.close();
	                if (preparedStatement != null) preparedStatement.close();
	                if (connection != null) connection.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        return role;
			}
}