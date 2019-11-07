package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import business.Actor;

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

	private Actor getActorFromResultSet(ResultSet rs) throws SQLException {
		// Get an actor from the result set
		int id = rs.getInt(1);
		String firstName = rs.getString(2);
		String lastName = rs.getString(3);
		String gender = rs.getString(4);
		LocalDate birthDate = rs.getDate(5).toLocalDate();
		
		Actor m = new Actor(id, firstName, lastName, gender, birthDate);
		return m;
	}

}
