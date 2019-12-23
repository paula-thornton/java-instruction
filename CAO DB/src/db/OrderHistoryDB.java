package db;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import business.OrderHistory;

public class OrderHistoryDB {

	private Connection getConnection() throws SQLException {
		String dbUrl = "jdbc:mysql://localhost:3306/cao_db?useSSL=false&allowPublicKeyRetrieval=true";
		String username = "cao_db_user";
		String pwd = "sesame";
		Connection conn = DriverManager.getConnection(dbUrl, username, pwd);
		return conn;
	}
	
	public List<OrderHistory> getAll(String upc) {
		
		List<OrderHistory> orderHistoryList = new ArrayList<>();
		String sql = "select * from OrderHistory";

		try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) {
				OrderHistory oh1 = getOrderHistoryFromResultSet(rs);
				orderHistoryList.add(oh1);
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return orderHistoryList;
	}
	
	public List<OrderHistory> getOrdHistForItem(String upc) {
		
		List<OrderHistory> orderHistoryList = new ArrayList<>();
		String sql = "select * from OrderHistory where upc = ? order by deliveryDate";

		try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
			ps.setString(1, upc);
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) {
				OrderHistory oh1 = getOrderHistoryFromResultSet(rs);
				orderHistoryList.add(oh1);
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return orderHistoryList;
	}
	
	public int add(OrderHistory oh) {
		int rowCount = 0;
		String sql = "INSERT INTO orderHistory "
				+ "(orderNumber, upc, deliveryDate, orderStatus, " +
				  " suggestQty, actualQty, receivedQty, adjustmentRsn) " +
		             "VALUES (?,?,?,?,?,?,?,?) ";
		try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
			ps.setInt(1, oh.getOrderNumber());
			ps.setString(2, oh.getUpc());
			ps.setObject(3, oh.getDeliveryDate());
			ps.setString(4, oh.getOrderStatus());
			ps.setInt(5, oh.getSuggestQty());
			ps.setInt(6, oh.getActualQty());
			ps.setInt(7, oh.getReceivedQty());
			ps.setString(8, oh.getAdjustmentRsn());

			rowCount = ps.executeUpdate();
		}
		catch (SQLException se) {
			System.out.println(se);
		}
		return rowCount;
	}
	
	public int update(OrderHistory oh) {
		int rowCount = 0;
		String sql = "UPDATE orderHistory SET deliveryDate = ?, orderStatus = ?, "
				+ "suggestQty = ?, actualQty = ?, receivedQty = ?, Adjustment Rsn = ? " +  
		             "WHERE orderNumber = ? AND upc = ?";
		try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
			ps.setObject(1, oh.getDeliveryDate());
			ps.setString(2, oh.getOrderStatus());
			ps.setInt(3, oh.getSuggestQty());
			ps.setInt(4, oh.getActualQty());
			ps.setInt(5, oh.getReceivedQty());
			ps.setString(6, oh.getAdjustmentRsn());
			ps.setInt(7, oh.getOrderNumber());
			ps.setString(8, oh.getUpc());

			rowCount = ps.executeUpdate();
		}
		catch (SQLException se) {
			System.out.println(se);
		}
		return rowCount;
	}
	
	public int delete(OrderHistory oh) {
		int rowCount = 0;
		String sql = "DELETE FROM orderHistory WHERE orderNumber = ? "
				+ "AND upc = ? ";
		try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
			ps.setObject(1, oh.getOrderNumber());
			ps.setString(2, oh.getUpc());
			rowCount = ps.executeUpdate();
		}
		catch (SQLException se) {
			System.out.println(se);			
		}
		return rowCount;
	}
	
	private OrderHistory getOrderHistoryFromResultSet(ResultSet rs) throws SQLException {
		int orderNumber = rs.getInt(1);
		String upc = rs.getString(2);
		LocalDate deliveryDate = rs.getDate(3).toLocalDate();
		String orderStatus = rs.getString(4);
		int suggestQty = rs.getInt(5);
		int actualQty = rs.getInt(6);
		int receivedQty = rs.getInt(7);
		String adjustmentRsn = rs.getString(8);
				
		OrderHistory oh = new OrderHistory(orderNumber, upc, deliveryDate, orderStatus,
				suggestQty, actualQty, receivedQty, adjustmentRsn);
		return oh;
	}

}
