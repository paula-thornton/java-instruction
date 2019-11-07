package db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import business.Stuffy;

public class StuffyDB {

	private Connection getConnection() throws SQLException {
		String dbUrl = "jdbc:mysql://localhost:3306/stuffy_db?useSSL=false&allowPublicKeyRetrieval=true";
		String username = "stuffy_db_user";
		String pwd = "sesame";
		Connection conn = DriverManager.getConnection(dbUrl, username, pwd);
		return conn;
	}
	
	public List<Stuffy> getAll() {

		String sql = "select * from stuffy";
		List<Stuffy> stuffys = new ArrayList<>();
		Stuffy s = null;
		try (Statement stmt = getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);) {

			while (rs.next()) {
				int id2      = rs.getInt(1);
				String type  = rs.getString(2);
				String color = rs.getString(3);
				String size  = rs.getString(4);
				int limbs    = rs.getInt(5);
				s = new Stuffy(id2, type, color, size, limbs);
				stuffys.add(s);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return stuffys;
	}
	
	public Stuffy get(int id) {
		String sql = "select * from stuffy where id = " + id;
		Stuffy s = null;
		try (Statement stmt = getConnection().createStatement();
			 ResultSet rs = stmt.executeQuery(sql);) {
			boolean stuffyExists = rs.next();
			if (stuffyExists) {
				// result set has a stuffy
				// process result set row
				int id2 = rs.getInt(1);
				String type = rs.getString(2);
				String color = rs.getString(3);
				String size = rs.getString(4);
				int limbs = rs.getInt(5);
				s = new Stuffy(id2, type, color, size, limbs);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	
	}
	
	public int add(Stuffy s) {
		int rowCount = 0;
		String sql = "INSERT INTO stuffy (Type, Color, Size, Limbs) " +  
		             "VALUES (?,?,?,?) ";
		try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
			ps.setString(1, s.getType());
			ps.setString(2, s.getColor());
			ps.setString(3, s.getSize());
			ps.setInt(4, s.getLimbs());

			rowCount = ps.executeUpdate();
		}
		catch (SQLException se) {
			System.out.println(se);
		}
		return rowCount;
	}
	
	public int update(Stuffy s) {
		int rowCount = 0;
		String sql = "UPDATE stuffy SET Type = ?, Color = ?, Size = ?, Limbs = ? " +  
		             "WHERE id = ? ";
		try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
			ps.setString(1, s.getType());
			ps.setString(2, s.getColor());
			ps.setString(3, s.getSize());
			ps.setInt(4, s.getLimbs());
			ps.setInt(5, s.getId());

			rowCount = ps.executeUpdate();
		}
		catch (SQLException se) {
			System.out.println(se);
		}
		return rowCount;
	}
	
	public int delete(Stuffy s) {
		int rowCount = 0;
		String sql = "DELETE FROM stuffy WHERE id = ? ";
		try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
			ps.setInt(1, s.getId());
			rowCount = ps.executeUpdate();
		}
		catch (SQLException se) {
			System.out.println(se);			
		}
		return rowCount;
	}

}
