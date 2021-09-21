import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class BankAccount {

	public static final byte ACCOUNT_TYPE_CURRENT = 1;
	public static final byte ACCOUNT_TYPE_SAVINGS = 2;

	private String accountNumber;
	private String pinNumber;
	private double balance;
	private byte accountType;

	static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	private ArrayList<Transactions> transactions = new ArrayList<Transactions>();

	public BankAccount(byte accountType, String accountNumber, String pinNumber) {
		this.accountType = accountType;
		this.accountNumber = accountNumber;
		this.pinNumber = pinNumber;
		this.balance = 0;
	}

	public BankAccount() {
		this.accountType = BankAccount.ACCOUNT_TYPE_CURRENT;
		this.balance = 0;
		this.pinNumber = "000000";
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getPinNumber() {
		return pinNumber;
	}

        public boolean checkPin(String pinAttempt) {
                return (pinAttempt.equals(this.pinNumber));
	}
                
	public void setPinNumber(String pinNumber) {
		this.pinNumber = pinNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void addTransaction(Transactions t) {
		if (t.getTransactionType() == Transactions.TRANS_TYPE_WITHDRAWAL) {
			if (t.getAmount() < 0) {
				System.out.println("BEGONE HACKER");
				this.balance = 0;
			} else {
				if (this.balance > t.getAmount()) {
					this.balance = (this.balance - t.getAmount());
					this.transactions.add(t);
				} else {
					System.err.println("Invalid transcation. Insufficient funds");
				}
			}
		} else if (t.getTransactionType() == Transactions.TRANS_TYPE_DEPOSIT) {
			this.balance = (this.balance + t.getAmount());
			this.transactions.add(t);
		} else {
			System.err.println("Invalid transaction, insufficient funds");
		}
	}
	public String printStatement() {
		String statement = "";
		for (int x = 0; x < transactions.size(); x++) {
			Transactions t = transactions.get(x);
			statement +=	dateFormat.format(t.getDate()) + " " + t.getTransactionTypeDescription() + " " + t.getAmount();
                        statement += "\n";
		}
		return statement;
	}
}
