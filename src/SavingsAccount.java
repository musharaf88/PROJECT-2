
public class SavingsAccount extends Account
{
//	Interest Rate
	private double interestRate;
	
//	Default Constructor
	public SavingsAccount()
	{
		super();
	}
	
	/*
	 * Parameter constructor to initialize Saving Account
	 * with a custom Account Number and a interest rate
	 */
	public SavingsAccount(int accountNumber,double interestRate)
	{
		super(accountNumber);
		
		this.interestRate=interestRate;
	}
	
//	Getter Functions
	public double getInterestRate() 
	{
		return this.interestRate;	
	}
	
	public void setInterestRate(double interestRate) 
	{
		this.interestRate=interestRate;
		
	}
	
	public double calcInterest() 
	{
		return balance * interestRate;
		
	}
	
	public void applyInterest() 
	{
		double interest = calcInterest();
		System.out.printf("Interest Amount %.2f Added To Balance%n", interest);
		deposite(interest);
	}
	
	
    public void deposite(double amount)
    {
    	if(amount>0)
    	{
    		balance += amount;
    		
    		System.out.printf("Amount %.2f Deposited%n", amount);
    		
    		System.out.printf("Current Balance is: %.2f%n", balance);
    	}
    	else
    	{
    		System.out.println("A negative amount cannot be deposited");
    	}
    	
    }
	
	public void withdraw(double amount)
	{
		if(amount > 0)
		{
			if((amount) <= balance)
			{
				System.out.printf("Amount of %.2f Withdrawn from Account%n", amount);
				
				balance -= amount;
				
				System.out.printf("Current balance is: %.2f%n", balance);
			}
		}
		else
		{
			System.out.println("Negative Amount cannot be withdraw");
		}
	}

	

}

