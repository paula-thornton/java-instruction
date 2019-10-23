package business;

public class CheckingAccount extends Account {
	
	private double fee;

	public CheckingAccount() {
		super();
	}

	public CheckingAccount(double balance, double fee) {
		super(balance);
		this.fee = fee;
	}
	
	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {  // This isn't needed
		this.fee = fee;
	}
	
	public void subtractMonthlyFee() {
		this.balance -= fee;
	}

}
