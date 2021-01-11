

/**
 * @author shikha
 *
 */

public class LastTransaction {

    private String type;

    public LastTransaction()
    {
        type = "";
    }

    public LastTransaction(String a)
    {
        if(a.equalsIgnoreCase("Withdraw")||a.equalsIgnoreCase("Deposit")||a.equalsIgnoreCase("Transfer"))
            type=a;
        else
            throw new IllegalArgumentException("Enter valid transaction type."); 
    }

	public String getType()
    {
        return type;
    }
    public void setType(String a)
    {
        if(a.equalsIgnoreCase("Withdraw")||a.equalsIgnoreCase("Deposit")||a.equalsIgnoreCase("Transfer"))
            type=a;
        else
            throw new IllegalArgumentException("Enter valid transaction type.");
    }
}