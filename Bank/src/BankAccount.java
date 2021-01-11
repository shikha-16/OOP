import java.io.Serializable;
import java.math.BigInteger;

/**
 * All bank details for an account are stored here.
 * @author shikha
 *
 */

@SuppressWarnings("serial")
public class BankAccount implements Comparable<BankAccount>, ITRules, Serializable {
	
	
	/**
	 * minimum balance of SBI bank = Rs.2000/- (in semi-urban areas)
	 */
	protected static final double minbalance = 200; 
	protected double balance = minbalance;
	protected int numberOfTransactions;
	private String accNo;
	protected LastTransaction lastTran;
	private PersonalDetails pd;
	private double rate,tax;
	
	
	protected double interestRate;
	protected double interest;
	private double taxDeducted;
	
	static BigInteger start = new BigInteger("180020131110"); 
	
	
	public BankAccount(double b, String n, String a)
	{
		if (b >= minbalance)
		{
			start = start.add(BigInteger.ONE);
			accNo = start.toString();
			
			balance = b;
			
			pd = new PersonalDetails(n,a);
			lastTran = new LastTransaction();
		}
		
		else
			throw new IllegalArgumentException("Amount entered must be greater than minimum balance: "+minbalance); 
	}
	
	public void deposit(double b)
	{
		balance = balance + b;
		numberOfTransactions += 1;
		lastTran.setType("Deposit");
	}
	
	public void withdraw(double b)
	{
		if( balance >= minbalance + b)
		{
			balance = balance - b;
			numberOfTransactions += 1;
			lastTran.setType("Withdraw");
		}
			
		else
		{
			throw new IllegalArgumentException("The amount you are trying to withdraw will leave an amount lesser than the minimum balance required for your account: "+minbalance);
		}
	}
	
	/**
	 * transfer money from this account to another
	 */
	public void transfer(BankAccount a, double amt)
	{
			this.withdraw(amt);
			a.deposit(amt);
			this.lastTran.setType("Transfer");
			a.lastTran.setType("Transfer");
	}
	
	public double getBalance()
	{
		return balance;
	}
	
	public String toString()
	{
		String s = "Account number: "+accNo+"\n"+ pd.toString()+"\nBalance: Rs. "+balance+"\nLast Transaction: "+lastTran.getType()+"\nNumber of Transactions: "+numberOfTransactions;
		return s;
	}
	
	
	//Lab7
	
	public double calculateTax(double amt)
	{
		// It will define 4 Income tax slabs  
	    // 1) >10,000: 3%,  2) >30,000:4%  3) >75,000: 8%  4) >1,00,000: 10%
		
		if(amt>100000)
			rate = 0.10;
		else if(amt>75000)
			rate = 0.08;
		else if(amt>30000)
			rate = 0.04;
		else if(amt>10000)
			rate = 0.03;
		
		tax = rate*amt;
		return tax;
		
	}
	
	@Override
	public int compareTo(BankAccount arg0) 
	{
		if(this.balance>arg0.balance)
			return 1;
		else if(this.balance==arg0.balance)
			return 0;
		else
			return -1;
	}
	
	public void addInterest()
	{
		interest = (balance * interestRate);
		taxDeducted = calculateTax(interest);
		balance += interest + taxDeducted;
	}

}
