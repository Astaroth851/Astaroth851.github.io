package com.aca.RyanBatesSound.controller;

import com.aca.RyanBatesSound.dao.AuthenticationDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet  {
	 private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    try {
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        
	        

	        AuthenticationDao dao = new AuthenticationDao();
	        String role = dao.authenticateUserAndRetrieveRole(username, password);
	       

	        if (role != null) {
	            // Authentication successful
	        	 request.getSession().setAttribute("userRole", role);
	            response.setStatus(HttpServletResponse.SC_OK);
	            response.getWriter().println("Authenticated as: " + role);
	        } else {
	            // Authentication failed
	            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	            response.getWriter().println("Invalid username or password");
	        }
	    } catch (Exception e) {
	        // Handle any exceptions
	        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	        response.getWriter().println("Internal Server Error");
	        e.printStackTrace(); // Print stack trace for debugging
	    }
	}
}