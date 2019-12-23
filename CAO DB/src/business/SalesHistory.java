package business;

import java.text.NumberFormat;
import java.time.LocalDate;

public class SalesHistory {

	private LocalDate salesDate;
	private String upc;
	private int retailMultiple;
	private double retail;
	private int units;
	
	public SalesHistory() {
		super();
	}

	public SalesHistory(LocalDate salesDate, String upc, int retailMultiple, double retail, int units) {
		super();
		this.salesDate = salesDate;
		this.upc = upc;
		this.retailMultiple = retailMultiple;
		this.retail = retail;
		this.units = units;
	}

	public LocalDate getSalesDate() {
		return salesDate;
	}

	public void setSalesDate(LocalDate salesDate) {
		this.salesDate = salesDate;
	}

	public String getUpc() {
		return upc;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}

	public int getRetailMultiple() {
		return retailMultiple;
	}

	public void setRetailMultiple(int retailMultiple) {
		this.retailMultiple = retailMultiple;
	}

	public double getRetail() {
		return retail;
	}

	public void setRetail(double retail) {
		this.retail = retail;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	
	@Override
	public String toString() {
		NumberFormat cf = NumberFormat.getCurrencyInstance(); // cf short for number format
		cf.setMinimumFractionDigits(2);
		cf.setMaximumFractionDigits(2);      
		
		return salesDate + "   " + upc + "   " + retailMultiple + " for " + cf.format(retail) + "   " + units;
	}
		
}
