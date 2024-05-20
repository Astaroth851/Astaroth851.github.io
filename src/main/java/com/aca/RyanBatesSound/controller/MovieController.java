package com.aca.RyanBatesSound.controller;

import java.util.List;

import com.aca.RyanBatesSound.model.Production;
import com.aca.RyanBatesSound.model.Movie;
import com.aca.RyanBatesSound.service.MovieService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
@Path("/movies")
public class MovieController {

	private MovieService service = new MovieService();
	
	@GET
	public List<Movie> getMovies() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		return service.getMovies();
	}
	
	@GET
	@Path("/production/{productionValue}")
	public List<Movie> getMoviesByProduction(@PathParam("productionValue") Production production) {
		return service.getMoviesByProduction(production);
	}
	
	@GET
	@Path("/releaseyear/{releaseYearValue}")
	public List<Movie> getMoviesByReleaseYear(@PathParam("releaseYearValue") Integer releaseYear) {
		return service.getMoviesByReleaseYear(releaseYear);
	}
	
	@GET
	@Path("/{idValue}")
	public List<Movie> getMoviesById(@PathParam("idValue") Integer movieId) {
		return service.getMoviesById(movieId);
	}
	
	@GET
	@Path("/title/{titleValue}")
	public List<Movie> getMoviesByTitle(@PathParam("titleValue") String title) {
		return service.getMoviesByTitle(title);
	}
	
	@GET
	@Path("/link/{linkValue}")
	public List<Movie> getMoviesByLink(@PathParam("linkValue") String link) {
		return service.getMoviesByLink(link);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Movie updateMovie(Movie updateMovie) {
		return service.updateMovie(updateMovie);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Movie createMovie(Movie newMovie) {
		System.out.println("image: " + newMovie.getImage());
		return service.createMovie(newMovie);
	}
	
	@DELETE
	@Path("/{idValue}")
	public Movie deleteMoviesById(@PathParam("idValue") Integer id) {
		return service.deleteMovieById(id);
	}
	
	@GET
	@Path("/report")
	public List<Movie> getReport(
			@QueryParam("startReleaseYear") Integer startReleaseYear,
			@QueryParam("endReleaseYear") Integer endReleaseYear) {
		return service.getReport(startReleaseYear, endReleaseYear);
	}


//	@Produces(MediaType.TEXT_PLAIN)
//	public String getMovies() {
//		return service.getMovies().toString();
}
