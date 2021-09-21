import java.util.*;

public class Customer {
	private String forename;
	private String surname;
	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
	private String postcode;
	private String phoneNumber;
	private String customerNumber;

	private ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();

	public Customer(String forename, String surname, String customerNumber) {
		this.forename = forename;
		this.surname = surname;
		this.customerNumber = customerNumber;
	}

	public Customer() {

	}

	public String getForename() {
		return forename;
	}

	public void setForename(String forename) {
		this.forename = forename;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine3() {
		return addressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public BankAccount[] getAccounts() {
		BankAccount list[] = new BankAccount[accounts.size()];
		list = accounts.toArray(list);
		return list;
	}

	public BankAccount getAccount(String accountNumber) {
		for (int x = 0; x < accounts.size(); x++) {
			if (accounts.get(x).getAccountNumber().equals(accountNumber)) {
				return accounts.get(x);
			}
		}
		return null;
	}

	public void addAccount(BankAccount newAccount) {
		accounts.add(newAccount);
		System.out.println(
				"New Account number" + newAccount.getAccountNumber() + "added to customer" + this.getCustomerNumber());

	}

	public boolean removeAccount(BankAccount accountNumber) {
		for (int x = 0; x < accounts.size(); x++) {
			if (accounts.get(x).getAccountNumber().equals(accountNumber)) {
				accounts.remove(x);
				System.out.println(
						"account number" + accountNumber + "Not deleted for Customer" + this.getCustomerNumber());
				return true;
			}

		}
		System.out.println("Accountnumber" + accountNumber + "not delted for ");
		return false;
	}

}
