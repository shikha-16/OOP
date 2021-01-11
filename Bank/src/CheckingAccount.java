
@SuppressWarnings("serial")
public class CheckingAccount extends BankAccount{
	
	private int transactionCount;
	private final int limit = 4;
	private final int fee = 17;
	
	private double interestRate;
	private double interest;
	private double taxDeducted;
	
	
	public CheckingAccount(double b, String n, String a, double r) {
		super(b, n, a);
		interestRate = r;
		interest = 0;
		
	}
	
	public void deposit(double b)
	{
		super.deposit(b);
		transactionCount += 1;
		deductFees();
	}
	
	public void withdraw(double b)
	{
		if( balance >= minbalance + b)
		{
			super.withdraw(b);
			transactionCount += 1;
			deductFees();
		}
			
		else
		{
			throw new IllegalArgumentException("The amount you are trying to withdraw will leave an amount lesser than the minimum balance required for your account: "+minbalance);
		}
	}
	
	public void transfer(BankAccount a, double amt)
	{
		super.transfer(a, amt);
		deductFees();
	}
	
	public void deductFees()
	{
		if (transactionCount>limit)
		{
			transactionCount=0;
			balance -= fee;
		}
		
	}
	
	public void addInterest()
	{
		interest = (balance * interestRate);
		taxDeducted = calculateTax(interest);
		balance += interest + taxDeducted;
	}
	
	

}
