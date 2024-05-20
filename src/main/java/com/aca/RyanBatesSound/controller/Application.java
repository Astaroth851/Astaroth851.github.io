package com.aca.RyanBatesSound.controller;

import org.glassfish.jersey.server.ResourceConfig;

import com.aca.RyanBatesSound.controller.MovieController;
import com.aca.RyanBatesSound.controller.AdminRoleResource;

public class Application extends ResourceConfig {
	  
	public Application() {
	        // Register resource classes with Jersey
	        register(MovieController.class);
	        register(AdminRoleResource.class); // Register the AdminRoleResource class

	  }
}
