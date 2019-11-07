package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import business.Movie;

public class MovieDB extends BaseDB {
	
	public List<Movie> list() {
		List<Movie> movieList = new ArrayList<>();
		String sql = "SELECT * FROM movie";
		try (PreparedStatement ps = getConnection().prepareStatement(sql);
				ResultSet rs = ps.executeQuery(sql);) {

			while (rs.next()) {
				Movie m = getMovieFromResultSet(rs);
				movieList.add(m);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return movieList;
	}
	
	public Movie get(int id) {
		Movie movie = null;
		String sql = "SELECT * FROM movie WHERE id = ?";
		try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				movie = getMovieFromResultSet(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return movie;
	}
	
	public int add(Movie m) {
		int rowCount = 0;
		String sql = "INSERT INTO movie (title, rating, year, director) VALUES (?, ?, ?, ?)";
		try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
			ps.setString(1,  m.getTitle());
			ps.setString(2,  m.getRating());
			ps.setInt(3, m.getYear());
			ps.setString(4, m.getDirector());
			rowCount = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCount;
	}

	public int update(Movie m) {
		int rowCount = 0;
		String sql = "UPDATE movie SET year = ? WHERE id = ?";
		try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
			ps.setInt(1, m.getYear());
			ps.setInt(2, m.getId());
			rowCount = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCount;
	}
	
	public int delete(Movie m) {
		int rowCount = 0;
		String sql = "DELETE from movie WHERE id = ?";
		try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
			ps.setInt(1, m.getId());
			rowCount = ps.executeUpdate();
		} catch (SQLIntegrityConstraintViolationException cv) {
			System.out.println("Can't remove a movie that has actors.");
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return rowCount;
	}
	
	private Movie getMovieFromResultSet(ResultSet rs) throws SQLException {
		// Get a movie from the result set
		int id = rs.getInt(1);
		String title = rs.getString(2);
		String rating = rs.getString(3);
		int year = rs.getInt(4);
		String director = rs.getString(5);
		Movie m = new Movie(id, title, rating, year, director);
		return m;
	}

}
