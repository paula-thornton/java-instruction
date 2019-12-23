package db;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import business.SalesHistory;

public class SalesHistoryDB {

	private Connection getConnection() throws SQLException {
		String dbUrl = "jdbc:mysql://localhost:3306/cao_db?useSSL=false&allowPublicKeyRetrieval=true";
		String username = "cao_db_user";
		String pwd = "sesame";
		Connection conn = DriverManager.getConnection(dbUrl, username, pwd);
		return conn;
	}
	
	public List<SalesHistory> getAll(String upc) {
		
		List<SalesHistory> salesHistoryList = new ArrayList<>();
		String sql = "select * from SalesHistory";

		try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) {
				SalesHistory sh1 = getSalesHistoryFromResultSet(rs);
				salesHistoryList.add(sh1);
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return salesHistoryList;
	}
	
	public List<SalesHistory> getForItem(String upc) {
		
		List<SalesHistory> salesHistoryList = new ArrayList<>();
		String sql = "select * from SalesHistory where upc = ? order by salesDate";

		try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
			ps.setString(1, upc);
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) {
				SalesHistory sh1 = getSalesHistoryFromResultSet(rs);
				salesHistoryList.add(sh1);
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return salesHistoryList;
	}
	
	public int add(SalesHistory s) {
		int rowCount = 0;
		String sql = "INSERT INTO salesHistory (salesDate, upc, retail multiple, " +
					 " retail, units) " +
		             "VALUES (?,?,?,?,?) ";
		try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
			ps.setObject(1, s.getSalesDate());
			ps.setString(2, s.getUpc());
			ps.setInt(3, s.getRetailMultiple());
			ps.setDouble(4, s.getRetail());
			ps.setInt(5, s.getUnits());

			rowCount = ps.executeUpdate();
		}
		catch (SQLException se) {
			System.out.println(se);
		}
		return rowCount;
	}
	
	public int update(SalesHistory s) {
		int rowCount = 0;
		String sql = "UPDATE salesHistory SET salesDate = ?, upc = ?, retailMultiple = ?, getRetail = ?, " +  
		             " units = ? WHERE id = ? ";
		try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
			ps.setObject(1, s.getSalesDate());
			ps.setString(2, s.getUpc());
			ps.setInt(3, s.getRetailMultiple());
			ps.setDouble(4, s.getRetail());
			ps.setInt(5, s.getUnits());

			rowCount = ps.executeUpdate();
		}
		catch (SQLException se) {
			System.out.println(se);
		}
		return rowCount;
	}
	
	public int delete(SalesHistory s) {
		int rowCount = 0;
		String sql = "DELETE FROM salesHistory WHERE salesDate = ? "
				+ "AND upc = ? ";
		try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
			ps.setObject(1, s.getSalesDate());
			ps.setString(2, s.getUpc());
			rowCount = ps.executeUpdate();
		}
		catch (SQLException se) {
			System.out.println(se);			
		}
		return rowCount;
	}
	
	private SalesHistory getSalesHistoryFromResultSet(ResultSet rs) throws SQLException {
		LocalDate salesDate = rs.getDate(1).toLocalDate();
		String upc = rs.getString(2);
		int retailMultiple = rs.getInt(3);
		double retail = rs.getDouble(4);
		int units = rs.getInt(5);
		
		SalesHistory sh = new SalesHistory(salesDate, upc, retailMultiple, retail, units);
		return sh;
	}

}
