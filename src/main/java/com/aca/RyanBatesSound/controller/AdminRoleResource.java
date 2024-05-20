package com.aca.RyanBatesSound.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;

@Path("/checkAdminRole")
public class AdminRoleResource {

	
	 @Context
	    private HttpServletRequest request;
	

	@GET
    @Produces(MediaType.APPLICATION_JSON)
	public String checkAdminRole() {
		//String role = authenticateUserAndRetrieveRole();
        String role = (String) request.getSession().getAttribute("userRole");

        // Return the user's role as JSON response
        return "{\"role\": \"" + role + "\"}";
		
       // return "{\"role\": \"admin\"}";
    }
	
	//private String authenticateUserAndRetrieveRole() {
 
	//return "admin";
//}
	
}
//@GET
//@Produces(MediaType.APPLICATION_JSON)
//public String checkAdminRole() {
//	System.out.println("checkAdminRole public string has been accesseed");
//  // Authenticate the user and retrieve their role
//  String role = authenticateUserAndRetrieveRole();
//  
//  // Return the user's role as JSON response
//  return "{\"role\": \"" + role + "\"}";
//}
//
//// Method to authenticate the user and retrieve their role
//private String authenticateUserAndRetrieveRole() {
//	System.out.println("authentticateUserAndRetrieveRole in ARR has been accessed");
//  // Implement your authentication logic here
//  // This could involve checking credentials against a database
//  // or verifying a token if you're using token-based authentication
//  
//  // For simplicity, let's assume the user is authenticated and their role is admin
//  return "admin";
//}
//

//public class AdminRoleResource implements Serializable {
//private AuthenticationDao authenticationDao = new AuthenticationDao();
//@GET
//@Produces(MediaType.APPLICATION_JSON)
//public String checkAdminRole(@QueryParam("username") String username, @QueryParam("password") String password) throws ServletException, IOException {
//    // Authenticate the user and retrieve their role
//    String role = authenticationDao.authenticateUserAndRetrieveRole(username, password);
//    
//    // Return the user's role as JSON response
//    return "{\"role\": \"" + role + "\"}";
