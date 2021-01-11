

/**
 * @author shikha
 *
 */

public class PersonalDetails {

    private String name, address;

    public PersonalDetails(String n, String a)
    {
        name = n;
        address= a;
    }
	
	public String toString()
	{
		String s = "Name: "+name +"\nAddress: "+address;
		return s;
	}

}