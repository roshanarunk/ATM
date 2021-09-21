import java.util.Date;

public class Transactions {
	public static final byte TRANS_TYPE_WITHDRAWAL = 1;
	public static final byte TRANS_TYPE_DEPOSIT = 2;

	private Date date;
	private double amount;
	private int transactionType;
	
	public Transactions(Date date, int transactionType, double amount) {
		if (transactionType != 1 && transactionType != 2) {
			System.out.println("Error Incorrect Transaction Type");
		}
		this.date = date;
		this.transactionType = transactionType;
		this.amount = amount;
	}
	
	//Setters and getters//
	
	public Date getDate() {
		return date;
	}
	
	public int getTransactionType() {
		return transactionType;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public String getTransactionTypeDescription() {
		if (this.getTransactionType() == Transactions.TRANS_TYPE_DEPOSIT) {
			return "Deposit";
		}
		else if (this.getTransactionType() == Transactions.TRANS_TYPE_WITHDRAWAL) {
			return "Withdrawal";
		}
		else {
			return "Error - Invalid Type";
		}
	}
	
	

}
