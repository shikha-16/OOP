import java.util.*;

@SuppressWarnings("serial")
public class BankAccountMonitored extends BankAccount{

	protected LinkedList<Action> deposits;
	protected HashMap<Integer,Action> withdrawals;
	static int transactionid = 0000;
	
	BankAccountMonitored(double b, String n, String a)
	{
		super(b,n,a);
		deposits = new LinkedList<Action>();
		withdrawals = new HashMap<Integer,Action>();
		
	}
	
	public void deposit(double b, int tid)
	{
		balance = balance + b;
		numberOfTransactions += 1;
		lastTran.setType("Deposit");
		
		Action p = new Action("Deposit",(long)b,tid);
		transactionid=tid+1;
		deposits.addLast(p);
		
	}
	
	public void withdraw(double b, int tid)
	{
		if( balance >= minbalance + b)
		{
			balance = balance - b;
			numberOfTransactions += 1;
			lastTran.setType("Withdraw");
			
			Action p = new Action("Withdraw",(long)b,tid);
			transactionid=tid+1;
			withdrawals.put((Integer)tid,p);
		}
			
		else
		{
			throw new IllegalArgumentException("The amount you are trying to withdraw will leave an amount lesser than the minimum balance required for your account: "+minbalance);
		}
	}

	
	public void getWithdrawal(int tid)
	{
		System.out.println(withdrawals.get((Integer)tid));
	}
	
	public void getDepositsList()
	{
        ListIterator<Action> li = deposits.listIterator(0); 
  
        System.out.println("The deposits list is as follows:"); 
        while(li.hasNext())
        { 
           System.out.print(li.next()); 
        }
	}
	
	public void getWithdrawalsMap()
	{
  
        Iterator<Map.Entry<Integer,Action>> hm = withdrawals.entrySet().iterator(); 
        
        System.out.println("The withdrawals list is as follows:"); 
        while(hm.hasNext())
        { 
        	Map.Entry<Integer,Action> mapElement = (Map.Entry<Integer,Action>)hm.next(); 
        	System.out.print(mapElement.getValue()); 
        }
	}
	
	
	public void removeDeposit(int t)
	{
		ListIterator<Action> li = deposits.listIterator(0); 
		while(li.hasNext())
        {
			Action k = li.next();
			if(k.tid == t)
			{
				deposits.remove(k);
				break;
			}
		}
	}
	
	public class Action{
		private String act;
		private long amount;
		private int tid;
		
		Action(String a, long n, int t)
		{
			act = a;
			amount = n;
			tid = t;
		}
		
		public String toString()
		{
			return "\n"+act+" "+amount;
		}	
	}
	
	
}
