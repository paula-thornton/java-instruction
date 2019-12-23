package db;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

import business.Item;

public class ItemDB {

	private Connection getConnection() throws SQLException {
		String dbUrl = "jdbc:mysql://localhost:3306/cao_db?useSSL=false&allowPublicKeyRetrieval=true";
		String username = "cao_db_user";
		String pwd = "sesame";
		Connection conn = DriverManager.getConnection(dbUrl, username, pwd);
		return conn;
	}
	
	public List<Item> getAll() {
		
		List<Item> itemList = new ArrayList<>();
		String sql = "select * from item";

		try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery(sql); 
			while (rs.next()) {
				Item i = getItemFromResultSet(rs);
				itemList.add(i);
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return itemList;
	}
	
	public Item getItem(String upc) {
		
		Item item = null;
		String sql = "select * from item where upc = ?";

		try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
			ps.setString(1, upc);
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) {
				item = getItemFromResultSet(rs);
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return item;
	}
	
	public int add(Item it) {
		int rowCount = 0;
		String sql = "INSERT INTO item "
				+ "(upc, description, retailMultiple, retail, " +
				  " boh, min, alloc, pack, status) " +
		             "VALUES (?,?,?,?,?,?,?,?, ?) ";
		try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
			ps.setString(1, it.getUpc());
			ps.setString(2, it.getDescription());
			ps.setInt(3, it.getRetailMultiple());
			ps.setDouble(4, it.getRetail());
			ps.setInt(5, it.getBoh());
			ps.setInt(6, it.getMin());
			ps.setInt(7, it.getAlloc());
			ps.setInt(8, it.getPack());
			ps.setString(9,  it.getStatus());

			rowCount = ps.executeUpdate();
		}
		catch (SQLException se) {
			System.out.println(se);
		}
		return rowCount;
	}
	
	public int update(Item it) {
		int rowCount = 0;
		String sql = "UPDATE item SET description = ?, retailMultiple = ?, retail = ?, "
				+ "boh = ?, min = ?, alloc = ?, pack = ?, status = ? " +  
		             "WHERE upc = ?";
		try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
			ps.setString(1, it.getDescription());
			ps.setInt(2, it.getRetailMultiple());
			ps.setDouble(3, it.getRetail());
			ps.setInt(4, it.getBoh());
			ps.setInt(5, it.getMin());
			ps.setInt(6, it.getAlloc());
			ps.setInt(7, it.getPack());
			ps.setString(8, it.getStatus());
			ps.setString(9, it.getUpc());

			rowCount = ps.executeUpdate();
		}
		catch (SQLException se) {
			System.out.println(se);
		}
		return rowCount;
	}
	
	public int delete(Item item) {
		int rowCount = 0;
		String sql = "DELETE FROM Item WHERE upc = ? ";
		try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
			ps.setObject(1, item.getUpc());
			rowCount = ps.executeUpdate();
		}
		catch (SQLException se) {
			System.out.println(se);			
		}
		return rowCount;
	}
	
	private Item getItemFromResultSet(ResultSet rs) throws SQLException {
		// Get an item from the result set
		String upc 			= rs.getString(1);
		String description 	= rs.getString(2);
		int retailMultiple 	= rs.getInt(3);
		double retail 		= rs.getDouble(4);
		int boh 			= rs.getInt(5);
		int min 			= rs.getInt(6);
		int alloc 			= rs.getInt(7);
		int pack 			= rs.getInt(8);
		String status 		= rs.getString(9);
						
		Item item = new Item(upc, description, retailMultiple, retail, boh, 
				min, alloc, pack, status);
		return item;
	}

}
