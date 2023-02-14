
//Base clase
//Abstrsct

public abstract class Account 
{
//	Account Number
    private int accountNumber;
	
//    Balance
	protected double balance;
	
//	Default Constructor
	public Account()
	{
		
	}
	
	
	public Account(int accountNumber)
	{
		this.accountNumber=accountNumber;
		balance=0;
	}
	
//	Getter Methods
	public int getAccountNumber()
	{
		return this.accountNumber;
	}
	
	public double getBalance()
	{
		return this.balance;
	}
	
//	Abstract
	/*
	 *Function to deposite funds into the account as long as
	 *the amount parameter is > 0
	 *
	 * Apply Transaction fee for the CheckingAccount
	 * 
	 * @param amount value to be deposited
	 */
	public abstract void deposite(double amount);
	
	
	/*
	 * Function to withdraw funds from the account as long as
	 * 1. Amount to withdraw must be > 0
	 * 2. Amount to withdraw must be <= balance
	 * 
	 * @param amount value to be withdraw
	 */
	public abstract void withdraw(double amount);
	
	

}
