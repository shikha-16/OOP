
@SuppressWarnings("serial")
public class FDAccount extends BankAccount 
{
	
	private int term;
	private double interestRate;
	private int transactionCount;
	private double interest;
	private double taxDeducted;

	public FDAccount(double b, String n, String a, int t) 
	{
		super(b, n, a);
		
		//Variable interest based on term for which invested (6% for upto 12 months, 7% for 12-36 months) and 8% for > 36 months;  
		
		term = t;
		
		if(term<=0)
			throw new IllegalArgumentException("Enter term as a positive integer"); 
		if(term<12)
			interestRate = 0.06;
		else if(term<36)
			interestRate = 0.07;
		else
			interestRate = 0.08;
	}
		
	public void withdraw(double a, int t)
	{
		if(t>=term)
		{
			addInterest();
			balance-=a;
		}
		else
			throw new RuntimeException("Transactions of withdrawal type not allowed for FD Account."); 
	}
	
	public void deposit(double b)
	{
		if(transactionCount<1)
		{
			super.deposit(b);
			transactionCount += 1;
		}
		else
		{
			throw new RuntimeException("More than 1 transaction not allowed for FD Account."); 
		}
		
	}
	
	public void transfer(BankAccount a, double amt)
	{
		throw new RuntimeException("You can't transfer money out of an FD Account."); 
	}
	
	public void addInterest()
	{
		interest = interestRate * term/12 * balance;
		taxDeducted = calculateTax(interest);
		balance += interest + taxDeducted;
	}
	
	
}
		


