package com.aca.RyanBatesSound.controller;

import com.aca.RyanBatesSound.dao.AuthenticationDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet  {
	 private static final long serialVersionUID = 1L;
	 private static final int MAX_LOGIN_ATTEMPTS = 3; 
	 private static final long LOCKOUT_DURATION = 5 * 60 * 1000;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    try {
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        
	        HttpSession session = request.getSession();
            Integer failedAttempts = (Integer) session.getAttribute("failedLoginAttempts");
            if (failedAttempts != null && failedAttempts >= MAX_LOGIN_ATTEMPTS) {
                // User is locked out
                long lockoutTime = session.getCreationTime() + LOCKOUT_DURATION;
                long remainingTime = lockoutTime - System.currentTimeMillis();
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                response.getWriter().println("Too many failed login attempts. Please try again in " + (remainingTime / 1000) + " seconds.");
                return;
                
            }

	        AuthenticationDao dao = new AuthenticationDao();
	        String role = dao.authenticateUserAndRetrieveRole(username, password);
	       

	        if (role != null) {
                // Authentication successful
                request.getSession().setAttribute("userRole", role);
                response.setStatus(HttpServletResponse.SC_OK);
                response.getWriter().println("Authenticated as: " + role);
                response.sendRedirect("/RyanBatesSound/#!/soundmain.html");
            } else {
                // Authentication failed
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().println("Invalid username or password");
                // Increment failed login attempts
                if (failedAttempts == null) {
                    failedAttempts = 1;
                } else {
                    failedAttempts++;
                }
                session.setAttribute("failedLoginAttempts", failedAttempts);
            }
        } catch (Exception e) {
            // Handle any exceptions
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().println("Internal Server Error");
            e.printStackTrace(); // Print stack trace for debugging
	}
}
}
