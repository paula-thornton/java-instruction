package business;

public class Item {

	private String upc;
	private String description;
	private int retailMultiple;
	private double retail;
	private int boh;
	private int min;
	private int alloc; 
	private int pack;
	private String status;
	
	public Item() {
		super();
	}
	
	public Item(String upc, String description, int retailMultiple, double retail, int boh, int min, int alloc,
			int pack, String status) {
		super();
		this.upc = upc;
		this.description = description;
		this.retailMultiple = retailMultiple;
		this.retail = retail;
		this.boh = boh;
		this.min = min;
		this.alloc = alloc;
		this.pack = pack;
		this.status = status;
	}
	public String getUpc() {
		return upc;
	}
	public void setUpc(String upc) {
		this.upc = upc;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public int getBoh() {
		return boh;
	}
	public void setBoh(int boh) {
		this.boh = boh;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getAlloc() {
		return alloc;
	}
	public void setAlloc(int alloc) {
		this.alloc = alloc;
	}
	public int getPack() {
		return pack;
	}
	public void setPack(int pack) {
		this.pack = pack;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Item [upc=" + upc + ", description=" + description + ", retailMultiple=" + retailMultiple + ", retail="
				+ retail + ", boh=" + boh + ", min=" + min + ", alloc=" + alloc + ", pack=" + pack + ", status="
				+ status + "]";
	}
	
	
	
}
