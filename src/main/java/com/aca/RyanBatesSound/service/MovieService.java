package com.aca.RyanBatesSound.service;

import java.util.List;
import com.aca.RyanBatesSound.dao.MovieDao;
import com.aca.RyanBatesSound.dao.MovieDaoImpl;
import com.aca.RyanBatesSound.model.Production;
import com.aca.RyanBatesSound.model.Movie;
import com.aca.RyanBatesSound.model.RequestError;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

public class MovieService {

	private MovieDao movieDao = new MovieDaoImpl();
	
	public List<Movie> getMovies() {
		return movieDao.getMovies();
	}
	

	public List<Movie> getMoviesById(Integer movieId) {
		validateMovieId(movieId);
		return movieDao.getMoviesById(movieId);
		}

	public List<Movie> getMoviesByProduction(Production production) {
		return movieDao.getMoviesByProduction(production);
	}
	
	public List<Movie> getMoviesByReleaseYear(Integer releaseYear) {
		validateReleaseYear(releaseYear);
		return movieDao.getMoviesByReleaseYear(releaseYear);
		}
	
	public List<Movie> getMoviesByTitle(String title) {
		validateMovieTitle(title);
		return movieDao.getMoviesByTitle(title);
		}
	
	public List<Movie> getMoviesByLink(String link) {
		validateMovieTitle(link);
		return movieDao.getMoviesByLink(link);
		}
	
	public Movie createMovie(Movie newMovie) {
		validateReleaseYear(newMovie.getReleaseYear());
		validateMovieTitle(newMovie.getTitle());
		return movieDao.createMovie(newMovie);
	}
	
	public Movie updateMovie(Movie updateMovie) {
		validateReleaseYear(updateMovie.getReleaseYear());
		validateMovieTitle(updateMovie.getTitle());
		
		List<Movie> myMovies = movieDao.getMoviesById(updateMovie.getId());
		
		if (myMovies.size() == 0) {
			movieNotFound(updateMovie.getId());
			return null;
		} else {
			return movieDao.updateMovie(updateMovie);
		}
	}


	public Movie deleteMovieById(Integer id) {
		return movieDao.deleteMovieById(id);
	}
	
	public List<Movie> getReport(Integer startReleaseYear, Integer endReleaseYear) {
		validateReleaseYearRange(startReleaseYear, endReleaseYear);
		return movieDao.getReport(startReleaseYear, endReleaseYear);
	}
	
	private void validateReleaseYear(Integer releaseYear) {
		if (releaseYear == null || (releaseYear < 1940 || releaseYear > 2024)) {
			RequestError error = new RequestError(1, 
					"Invalid value for release year '" + releaseYear + "'. Value must be >= 1940 and <= 2023");
			makeError(error);
		}
	}

	private void validateMovieId(Integer movieId) {
		if (movieId < 1) {
			RequestError error = new RequestError(2, 
					"Invalid value for movie id '" + movieId + "'. Value must be > 0.");
			makeError(error);
		}
	}	
	
	private void validateMovieTitle(String title) {
		if (null == title || title.length() == 0) {
		RequestError error = new RequestError(3, 
				"Invalid value for movie title '" + title + "'. Value must have length > 0.");
		makeError(error);
		}
		
	}

	private void movieNotFound(Integer id) {
			RequestError error = new RequestError(4, 
					"Movie not found, id '" + id + "'.");
			makeError(error);
	}
	
	private void validateReleaseYearRange(Integer startReleaseYear, Integer endReleaseYear) {
		validateReleaseYear(startReleaseYear);
		validateReleaseYear(endReleaseYear);
		if (startReleaseYear > endReleaseYear) {
			RequestError error = new RequestError(5, 
					"Invalid range for release year, start: '" + startReleaseYear + "', end: '" + endReleaseYear + "'.");
		makeError(error);
		}
	
	}
	private void makeError(RequestError error) {
		Response response = Response.status(400)
				.entity(error)
				.build();
		throw new WebApplicationException(response);
	}
	
//	public List<Movie> getReport(Integer startReleaseYear, Integer endReleaseYear) {
//		
//		return null;
//	}
}
