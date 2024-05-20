package com.aca.RyanBatesSound.dao;

import java.sql.Statement;
import java.time.LocalDateTime;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Base64;


import com.aca.RyanBatesSound.model.Production;
import com.aca.RyanBatesSound.model.Movie;

public class MovieDaoImpl implements MovieDao {
	
	private static String selectAllMovies = 
			"SELECT id, title, releaseYear, productionId, updateDateTime, createDateTime, img, link\r\n" +
			"FROM movies";
	
	private static String selectMoviesByProduction = 
			"SELECT id, title, releaseYear, productionId, updateDateTime, createDateTime, img, link " +
			"FROM movies" +
			"WHERE productionID = ? ";
	
	private static String selectMoviesByReleaseYear = 
			"SELECT id, title, releaseYear, productionId, updateDateTime, createDateTime, img, link\r\n" +
			"FROM movies " +
			"WHERE releaseYear = ?";
	
	private static String selectMoviesByTitle =
			"SELECT id, title, releaseYear, productionId, updateDateTime, createDateTime, img, link\r\n" + 
			"FROM movies " +
			"WHERE title LIKE ? ";
	
	private static String selectMoviesById = 
			"SELECT id, title, releaseYear, productionId, updateDateTime, createDateTime, img, link " +
			"FROM movies " +
			"WHERE id = ?";
	
	private static String selectMoviesByReleaseYearRange = 
			"SELECT id, title, releaseYear, productionId, updateDateTime, createDateTime, img, link " +
			"FROM movies " +
			"WHERE releaseYear >= ? " +
			"AND releaseYear <= ? ";
	private static String selectMoviesByLink =
			"SELECT id, title, releaseYear, productionId, updateDateTime, createDateTime, img, link\r\n" + 
			"FROM movies " +
			"WHERE link = ?";
	
//	private static String selectMoviesByImage =
//			"SELECT id, title, releaseYear, productionId, updateDateTime, createDateTime, img, link\r\n" + 
//			"FROM movies " +
//			"WHERE img = ?";
	
	private static String deleteMoviesById = 
			"DELETE FROM movies " + 
			"WHERE id = ?";
	
	private static String insertMovie =
			"INSERT INTO movies (title, releaseYear, productionId, img, link) " +
			"VALUES " +
			"(?,?,?,?,?)";
	
	private static String updateMovieById = 
			"UPDATE movies " +
			"SET title = ?, " +
			"	 releaseYear = ?," +
			"	 productionId = ?," +
			"	 img = ?," +
			"	 link = ? " +
			"WHERE id = ?";
	


	@Override
	public List<Movie> getMovies() {
		List<Movie> myMovies = new ArrayList<Movie>();
		ResultSet result = null;
		Statement statement = null;
		
		Connection connection = MariaDbUtil.getConnection();

		try {
		statement = connection.createStatement();
		result = statement.executeQuery(selectAllMovies);
		myMovies = makeMovie(result);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return myMovies;
	}

	private List<Movie> makeMovie(ResultSet result) throws SQLException {
		List<Movie> myMovies = new ArrayList<Movie>();
		while(result.next()) {
			Movie movie = new Movie();
			movie.setId(result.getInt("id"));
			movie.setTitle(result.getString("title"));
			movie.setReleaseYear(result.getInt("releaseYear"));
		
			byte[] picture = result.getBytes("img");
			if (picture != null) {
				String pictureString = Base64.getEncoder().encodeToString(picture);
				movie.setImage(pictureString);
			} else {
				movie.setImage(null);
			}
			
			movie.setLink(result.getString("link"));
 
			
			String productionString = result.getString("productionId");
			Production production = Production.convertStringToProduction(productionString);
			movie.setProduction(production);
			
			movie.setUpdateDateTime(result.getObject("updateDateTime", LocalDateTime.class));
			movie.setCreateDateTime(result.getObject("createDateTime", LocalDateTime.class));
			
			myMovies.add(movie);
		}
		
		return myMovies;
	}

	@Override
	public List<Movie> getMoviesByProduction(Production production) {
		List<Movie> myMovies = new ArrayList<Movie>();
		ResultSet result = null;
		PreparedStatement statement = null;
		
		Connection connection = MariaDbUtil.getConnection();
		
		try {
		statement = connection.prepareStatement(selectMoviesByProduction);
		statement.setString(1, production.toString());
		
		result = statement.executeQuery();
		myMovies = makeMovie(result);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return myMovies;
	}

	@Override
	public List<Movie> getMoviesByReleaseYear(Integer releaseYear) {
		List<Movie> myMovies = new ArrayList<Movie>();
		ResultSet result = null;
		PreparedStatement statement = null;
		
		Connection connection = MariaDbUtil.getConnection();
	
		try {
		statement = connection.prepareStatement(selectMoviesByReleaseYear);
		statement.setInt(1, releaseYear);
		
		result = statement.executeQuery();
		myMovies = makeMovie(result);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return myMovies;
	}

	@Override
	public List<Movie> getMoviesById(Integer movieId) {
		List<Movie> myMovies = new ArrayList<Movie>();
		ResultSet result = null;
		PreparedStatement statement = null;
		
		Connection connection = MariaDbUtil.getConnection();
	
		try {
		statement = connection.prepareStatement(selectMoviesById);
		statement.setInt(1, movieId);
		
		result = statement.executeQuery();
		myMovies = makeMovie(result);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return myMovies;
	}

	@Override
	public List<Movie> getMoviesByTitle(String title) {
		List<Movie> myMovies = new ArrayList<Movie>();
		ResultSet result = null;
		PreparedStatement statement = null;
		
		Connection connection = MariaDbUtil.getConnection();
		
		try {
		statement = connection.prepareStatement(selectMoviesByTitle);
		statement.setString(1, "%" + title + "%");
		
		result = statement.executeQuery();
		myMovies = makeMovie(result);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return myMovies;
	}
	
	@Override
	public List<Movie> getMoviesByLink(String link) {
		List<Movie> myMovies = new ArrayList<Movie>();
		ResultSet result = null;
		PreparedStatement statement = null;
		
		Connection connection = MariaDbUtil.getConnection();
	
		try {
		statement = connection.prepareStatement(selectMoviesByLink);
		statement.setString(1, link);
		
		result = statement.executeQuery();
		myMovies = makeMovie(result);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return myMovies;
	}
	
//	@Override
//	public List<Movie> getMoviesByImage(String img) {
//		List<Movie> myMovies = new ArrayList<Movie>();
//		ResultSet result = null;
//		PreparedStatement statement = null;
//	
//		Connection connection = MariaDbUtil.getConnection();	
//		try {
//		statement = connection.prepareStatement(selectMoviesByImage);
//		statement.setString(1, img);
//		
//		result = statement.executeQuery();
//		myMovies = makeMovie(result);
//		
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return myMovies;	}
//	

	@Override
	public Movie createMovie(Movie newMovie) {
		PreparedStatement ps = null;
		Connection connection = MariaDbUtil.getConnection();
	
		try {
			ps = connection.prepareStatement(insertMovie);
			ps.setString(1, newMovie.getTitle());
			ps.setInt(2, newMovie.getReleaseYear());
			ps.setString(3, newMovie.getProduction().toString());
			
			if (newMovie.getImage() != null) {
				InputStream stream =
						new ByteArrayInputStream(Base64.getDecoder().decode(newMovie.getImage()));
				ps.setBlob(4, stream);
			} else {
				ps.setBinaryStream(4, null);
			}
			ps.setString(5, newMovie.getLink());
			
			
			//updateRowCount = ps.executeUpdate();
			int rowCount = ps.executeUpdate();
			System.out.println("rows inserted: " + rowCount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		return newMovie;
	}

	@Override
	public Movie updateMovie(Movie updateMovie) {
		PreparedStatement ps = null;
		Connection connection = MariaDbUtil.getConnection();
		
		try {
			ps = connection.prepareStatement(updateMovieById);
			ps.setString(1, updateMovie.getTitle());
			ps.setInt(2, updateMovie.getReleaseYear());
			ps.setString(3, updateMovie.getProduction().toString());
			
			if (updateMovie.getImage() != null) {
				InputStream stream =
						new ByteArrayInputStream(Base64.getDecoder().decode(updateMovie.getImage()));
				ps.setBlob(4, stream);
			} else {
				ps.setBinaryStream(4, null);
			}
			
			ps.setString(5, updateMovie.getLink());
			ps.setInt(6, updateMovie.getId());
			
			
		
			int rowCount = ps.executeUpdate();
			System.out.println("rows updated: " + rowCount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return updateMovie;
	}

	@Override
	public Movie deleteMovieById(Integer id) {
		List<Movie> movies = getMoviesById(id);
		Movie movieToDelete = null;
		
		if (movies.size() > 0) {
			movieToDelete = movies.get(0);
			int updateRowCount = 0;
			PreparedStatement ps = null;
			
			Connection connection = MariaDbUtil.getConnection();
	
			try {
				ps = connection.prepareStatement(deleteMoviesById);
				ps.setInt(1, id);
				updateRowCount = ps.executeUpdate();
				System.out.println("rows deleted: " + updateRowCount);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return movieToDelete;
	}

	@Override
	public List<Movie> getReport(Integer startReleaseYear, Integer endReleaseYear) {
		List<Movie> myMovies = new ArrayList<Movie>();
		ResultSet result = null;
		PreparedStatement statement = null;
		
		Connection connection = MariaDbUtil.getConnection();
	
		try {
		statement = connection.prepareStatement(selectMoviesByReleaseYearRange);
		statement.setInt(1, startReleaseYear);
		statement.setInt(2, endReleaseYear);
		
		result = statement.executeQuery();
		myMovies = makeMovie(result);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return myMovies;
	}
}
