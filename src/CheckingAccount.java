
public class CheckingAccount extends Account
{
//	Default Transaction Fee
private static double FEE=2.5;
	
//  Default Constructor
	public CheckingAccount()
	{
		super();
	}
	
	/*
	 * Parameter constructor to initialize CheckingAccount
	 * with a custom Account Number and a Customer Transaction
	 * Fee
	 */
	public CheckingAccount(int accountNumber,double fee)
	{
		super(accountNumber);
		
		FEE=fee;
	}
	
	/*
	 *Function to deposite funds into the account as long as
	 *the amount parameter is > 0
	 *
	 * Apply Transaction fee for the CheckingAccount
	 * 
	 * @param amount value to be deposited
	 */
    public void deposite(double amount)
    {
    	if(amount > 0)
    	{
//    		First Check Amount
    		balance += amount;
    		System.out.printf("Amount %.2f deposited%n", amount);
    		
//    		Apply Transaction Fee
    		balance -= FEE;
    		System.out.printf("Fee %.2f Applied%n", FEE);
    		System.out.printf("Current Balance is: %.2f%n", balance);
    	}
    	else
    	{
    		System.out.println("A Negative amount cannot be deposited");
    	}  	
    }
	
    /*
     * * Function to withdraw funds from the account as long as
	 * 1. Amount to withdraw must be > 0
	 * 2. Amount to withdraw must be <= balance
	 * 
	 * @param amount value to be withdraw
     */
	public void withdraw(double amount)
	{
//		same check
		if(amount > 0)
		{
//			check sufficiant balance
			if((amount+FEE) <= balance)
			{
				System.out.printf("Amount of %.2f Withdrawn from Account%n", amount);
				balance -= amount;
				balance -= FEE;
				System.out.printf("Fee of %.2f applied%n", FEE);
				System.out.printf("Current Balance is: %.2f%n", balance);
			}
		}
		else
		{
			System.out.println("Negative Amount cannot be withdraw");
		}
	}


}
