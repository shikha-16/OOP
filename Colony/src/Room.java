/**
 * A Room object is a part of House.
 * 
 */
public class Room extends java.lang.Object{
	
	private int	height;
	private int	length;
	private int	width;
	
	public Room(int d)
	{
		length = d;
		width = d;
		height = d;
	}
	
	public Room(int l, int w, int h)
	{
		length = l;
		width = w;
		height = h;
	}

	public int getLateralArea()	{
		//TODO Change the return value as required.
		return 2*height*(length+width);
	}

	public int getFloorArea() {
		//TODO Change the return value as required.
		return length*width;
	}
}