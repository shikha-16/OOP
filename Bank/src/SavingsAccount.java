
@SuppressWarnings("serial")
public class SavingsAccount extends BankAccount {
	
	private double interestRate;
	private double interest;
	private double taxDeducted;

	public SavingsAccount(double b, String n, String a, double r) {
		super(b, n, a);
		interestRate = r;
		interest = 0;
		
	}
	
	public void addInterest()
	{
		interest = (balance * interestRate);
		taxDeducted = calculateTax(interest);
		balance += interest + taxDeducted;
	}
	
	

}
