package com.aca.RyanBatesSound.dao;

import java.util.List;

import com.aca.RyanBatesSound.model.Production;
import com.aca.RyanBatesSound.model.Movie;

public interface MovieDao {
	
	public List<Movie> getMovies();
	public List<Movie> getMoviesByProduction(Production production);
	public List<Movie> getMoviesByReleaseYear(Integer releaseYear);
	public List<Movie> getMoviesById(Integer movieId);
	public List<Movie> getMoviesByTitle(String title);
	public List<Movie> getMoviesByLink(String link);
	public Movie createMovie(Movie newMovie);
	public Movie updateMovie(Movie updateMovie);
	public Movie deleteMovieById(Integer id);
	public List<Movie> getReport(Integer startReleaseYear, Integer endReleaseYear);
}
