package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import business.Actor;
import business.Movie;

public class ActorDB extends BaseDB {
	
	public List<Actor> list() {
		List<Actor> actorList = new ArrayList<>();
		String sql = "SELECT * FROM actor";
		try (PreparedStatement ps = getConnection().prepareStatement(sql);
				ResultSet rs = ps.executeQuery(sql);) {

			while (rs.next()) {
				Actor a = getActorFromResultSet(rs);
				actorList.add(a);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return actorList;
	}
	
	public Actor get(int id) {
		Actor actor = null;
		String sql = "SELECT * FROM actor WHERE id = ?";
		try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				actor = getActorFromResultSet(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actor;
	}
	
	public int add(Actor a) {
		int rowCount = 0;
		String sql = "INSERT INTO actor (firstname, lastname, gender, birthdate) " +
				"VALUES (?, ?, ?, ?)";
		try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
			ps.setString(1, a.getFirstName());
			ps.setString(2, a.getLastName());
			ps.setString(3, a.getGender());
			ps.setObject(4, a.getBirthDate());
			rowCount = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCount;
	}
	
	public int update(Actor a) {
		int rowCount = 0;
		String sql = "UPDATE actor SET birthdate = ? WHERE id = ?";
		try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
			ps.setObject(1, a.getBirthDate());
			ps.setInt(2, a.getId());
			rowCount = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCount;
	}
	
	public int delete(Actor a) {
		int rowCount = 0;
		String sql = "DELETE FROM actor WHERE id = ?";
		try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
			ps.setInt(1, a.getId());
			rowCount = ps.executeUpdate();
			
		} catch (SQLIntegrityConstraintViolationException cv) {
			System.out.println("Can't remove an actor that has a movie.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCount;
	}

	private Actor getActorFromResultSet(ResultSet rs) throws SQLException {
		// Get an actor from the result set
		int id = rs.getInt(1);
		String firstName = rs.getString(2);
		String lastName = rs.getString(3);
		String gender = rs.getString(4);
		LocalDate birthDate = rs.getDate(5).toLocalDate();
		
		Actor a = new Actor(id, firstName, lastName, gender, birthDate);
		return a;
	}

}
