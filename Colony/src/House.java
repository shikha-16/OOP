/**
 * A house object is part of a colony
 *
 */

public class House extends java.lang.Object{
	
	private static final int ELECTRICITY_CHARGES = 600	;
	//Represents a final static int that represents the electricity charges per house member.
	private int	houseNumber	;
	//Represents the house number.
	private static final int MAX_ROOMS = 5;	
	//Represents a final static int that represents the maximum number of rooms that can be there in house.
	private int	noOfPeople	;
//	Represents the number of people.
	private int	noOfRooms	;
//	Represents the number of rooms in the house.
	private static final int	PAINTING_RATE = 5;	
//	Represents a final static int that represents the painting rate of a room.
	private Room[]	rooms	;
//	Represents an array containing objects of Room class.
	private static final int TAX = 40	;
//	Represents a final static int that represents the tax per room floor area.
	private static final int WATER_CHARGES = 300;	
//	Represents a final static int that represents the water charges per house member.

	
	public House(int num, int people)
	{
		houseNumber = num;
		noOfPeople = people;
		rooms = new Room[MAX_ROOMS];
		noOfRooms = 0;
		
	}
	public boolean addRoom(int l,int b,int h){
		//TODO Change the return value as required.
		Room r = new Room(l,b,h);
		if(noOfRooms >= (MAX_ROOMS))
			return false;
		else
		{
			rooms[noOfRooms]=r;
			noOfRooms+=1;
			return true;
		}
	}

	public boolean addRoom(int d){
		//TODO Change the return value as required.
		Room r = new Room(d);
		if(noOfRooms >= MAX_ROOMS)
			return false;
		else
		{
			rooms[noOfRooms]=r;
			noOfRooms+=1;
			return true;
		}
	}

	public int getCostofPaint(){
		//TODO Change the return value as required.
		int area=0;
		for(int i=0;i<noOfRooms;i++)
		{
			area = area + rooms[i].getLateralArea();
		}
		return PAINTING_RATE*area;
	}
	
	public int getMaintenanceCost(){
		//TODO Change the return value as required.
		//NOTE : If houseNumber%3==0 then we reduce the cost by Rs 100 
		//tax per room = TAX*(room floor area)
//		total electricity charges = noOfPeople*ELECTRICITY_CHARGES, 
//				and total water charges = noOfPeople*WATER_CHARGES.
		//The annual Maintenance cost of each house is calculated by the usage of
//		water and electricity plus the annual painting cost and land tax to be paid to
//		the Government.
//		Water and power usage are calculated based on the number of people
//		residing in the house.
//		Painting and land tax are based on the lateral surface area and floor area
//		of each room inside a particular house.
		
		int cost = 0;
		int area=0;
		for(int i=0;i<noOfRooms;i++)
		{
			area = area + rooms[i].getFloorArea();
		}
		

		int roomtax = TAX*area;
		int electricity = noOfPeople*ELECTRICITY_CHARGES;
		int water = noOfPeople*WATER_CHARGES;
		
		cost = roomtax + electricity + water + getCostofPaint();
		
		if(houseNumber%3==0)
		{
			if(cost>=100)
				cost = cost - 100;
			else
				cost = 0;
		}
		return cost;
	}
}