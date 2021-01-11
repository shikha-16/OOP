public class Colony extends java.lang.Object{

	private java.lang.String colonyName;	
//	Represents the house number.
	private static final int	MAX_HOUSES = 10;	
//	Represents a final static int that represents the Maximum number of Houses in a colony.
	private int	noOfHouses	;
//	Represents the number of houses in the colony.
	private House[]	quarters	;
//	Represents an array containing objects of house class.
	
	
	public Colony(String Name) 
	{
//		 Takes an input parameter Name and set the colonyName to Name .
//		 It is also used to initialize the quarters array with MAX_HOUSES houses. It also initilazes the noOfHouses to zero.
		 colonyName = Name;
		 quarters = new House[MAX_HOUSES];
		 noOfHouses = 0;
	}
	
	public String getColonyName() {
		//TODO Change the return value as required.
		return colonyName;
	}

	public boolean addHouse(House h) {
		//TODO Change the return value as required.
		
		if(noOfHouses >= MAX_HOUSES)
			return false;
		else
		{
			quarters[noOfHouses]=h;
			noOfHouses+=1;
			return true;
		}
	}
	
	public int getTotalMaintenanceCost() {
		//TODO Change the return value as required.
		int mc=0;
		for(int i=0;i<noOfHouses;i++)
		{
			mc = mc + quarters[i].getMaintenanceCost();
		}
		return mc;
	}
}