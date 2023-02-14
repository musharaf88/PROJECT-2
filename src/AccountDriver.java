import java.util.Scanner;

public class AccountDriver 
{
//	Entry Point of Program
	public static void main(String[] args) 
	{
		Scanner keyboard=new Scanner(System.in);	
		
//		Create Array Of Program
		Account account [] = new Account[10];
		int numAccount = 0;
		
		int choice;
		do
		{
			choice = menu(keyboard);
			System.out.println();
			
			if(choice == 1)
			{
				account[numAccount++] = createAccount(keyboard);
			}
			else if(choice == 2)
			{
				doDeposit(account, numAccount, keyboard);
			}
			else if(choice == 3)
			{
				doWithdraw(account, numAccount, keyboard);
			}
			else if(choice == 4)
			{
				applyInterest(account, numAccount, keyboard);
			}
			else 
			{
			System.out.println("GoOd ByE");
			}
			System.out.println();
		}
		while(choice != 5);
	}
	
	/*
	 * Account Choice
	 */
	public static int accountMenu(Scanner keyboard)
	{
		System.out.println("Select Account Type: ");
		System.out.println("1. Checking Account");
		System.out.println("2. Saving Account");
		
		int choice;
		do
		{
			System.out.println("Enter Choice: ");
			choice = keyboard.nextInt();
		}
		while(choice < 1 || choice > 2);
		
		return choice;
	}
	
	public static int searchAccount(Account accounts [], int count, int accountNumber)
	{
		for(int i=0; i<count; i++)
		{
			if(accounts[i].getAccountNumber() == accountNumber)
			{
				return i;
			}
		}
		return -1;
	}
	
	/*
	 * Function to perform Deposite on a selected account
	 */
	public static void doDeposit(Account accounts [], int count, Scanner keyboard)
	{
//		Get the account number
		System.out.println("Please Enter Account Number: ");
		int accountNumber = keyboard.nextInt();
		
//		Search for account
		int index = searchAccount(accounts, count, accountNumber);
		if(index >= 0)
		{
//		Amount
		System.out.println("Please Enter Deposit Number: ");
		double amount = keyboard.nextDouble();
		accounts[index].deposite(amount);
		}
		else
		{
			System.out.println("No Account exist with AccountNumber: "+ accountNumber);
		}
	}
	
	public static void doWithdraw(Account accounts [], int count, Scanner keyboard) 
	{
//		Get the account number
		System.out.println("Please Enter Account Number: ");
		int accountNumber = keyboard.nextInt();
		int index = searchAccount(accounts, count, accountNumber);
		
//		C
		if(index >= 0)
		{
//		Amount	
		System.out.println("Please Enter Withdraw Amount: ");
		
		double amount = keyboard.nextDouble();
		
		accounts[index].withdraw(amount);
		}
		else
		{
			System.out.println("No Account exist with AccountNumber: "+ accountNumber);
		}
		
	}
	
	public static void applyInterest(Account account [], int count, Scanner keyboard) 
	{
        
//		Get the account number
        System.out.println("Please Enter Account Number: ");
		int accountNumber = keyboard.nextInt();
		
//		Get the account number
		int index = searchAccount(account, count, accountNumber);
		if(index >= 0)
		{
//			Must be instance of saving account
			if(account[index] instanceof SavingsAccount)
			{
				
				((SavingsAccount)account[index]).applyInterest();
			}
		}
		else
		{
			System.out.println("No Account exist with AccountNumber: "+accountNumber);
		}
	}
	
	/*
	 * Fuction to create a new Account
	 */
	public static Account createAccount(Scanner keyboard)
	{
		
		Account account = null;
		
		int choice = accountMenu(keyboard);
		
		int accountNumber;
		
		System.out.println("Enter Account Number: ");
		
		accountNumber = keyboard.nextInt();
		
		if(choice == 1 )    //Checking Account
		{
			System.out.println("Enter Transaction Fee: ");
			double fee = keyboard.nextDouble();
			account = new CheckingAccount(accountNumber,fee);
		}
		else               //Saving Account
		{
			System.out.println("Please Enter Interest Rate: ");
			double ir = keyboard.nextDouble();
			account = new SavingsAccount(accountNumber,ir);
		}
		
		return account;
	}
	
	/*
	 * Menu to display option and get the user's selection
	 */
	public static int menu(Scanner keyboard) 
	{
		System.out.println("Bank Account Menu");
		System.out.println("1. Create New Account");
		System.out.println("2. Deposite Funds");
		System.out.println("3. Withdraw Funds");
		System.out.println("4. Apply Interest");
		System.out.println("5. Quit");
		
		int choice;
		
		do
		{
			System.out.println("Enter Choice: ");
			choice = keyboard.nextInt();
		}
		while(choice < 1 || choice > 5);
			
			return choice;
	}
	

}
