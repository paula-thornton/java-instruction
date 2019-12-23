package business;

import java.time.LocalDate;

public class OrderHistory {
	
	private int orderNumber;
	private String upc;
	private LocalDate deliveryDate;
	private String orderStatus;
	private int suggestQty;
	private int actualQty;
	private int receivedQty;
	private String adjustmentRsn;
	
	public OrderHistory() {
		super();
	}
	
	public OrderHistory(int orderNumber, String upc, 
			LocalDate deliveryDate, String orderStatus, int suggestQty,   
			int actualQty, int receivedQty, String adjustmentRsn) {
		super();
		this.orderNumber = orderNumber;
		this.upc = upc;
		this.deliveryDate = deliveryDate;
		this.orderStatus = orderStatus;
		this.suggestQty = suggestQty;
		this.actualQty = actualQty;
		this.receivedQty = receivedQty;
		this.adjustmentRsn = adjustmentRsn;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getUpc() {
		return upc;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}
	
	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public int getSuggestQty() {
		return suggestQty;
	}

	public void setSuggestQty(int suggestQty) {
		this.suggestQty = suggestQty;
	}

	public int getActualQty() {
		return actualQty;
	}

	public void setActualQty(int actualQty) {
		this.actualQty = actualQty;
	}

	public int getReceivedQty() {
		return receivedQty;
	}

	public void setReceivedQty(int receivedQty) {
		this.receivedQty = receivedQty;
	}

	public String getAdjustmentRsn() {
		return adjustmentRsn;
	}

	public void setAdjustmentRsn(String adjustmentRsn) {
		this.adjustmentRsn = adjustmentRsn;
	}

	@Override
	public String toString() {
		String adjRsn;
		if (adjustmentRsn == null ) {
			adjRsn = " ";
		} else {
			adjRsn = adjustmentRsn;
		}
		return orderNumber + "  " + upc + "  " + deliveryDate 
				+ "  " + orderStatus + "  " + suggestQty + "\t" + actualQty
				+ "\t" + receivedQty + "\t" + adjRsn;
	}
		
}
