/**
 * This program is for defining the fraction.
 * We can reuse codes in the methods. We can use addFraction in subtractFraction by modifying the numerator. Similarly, we can use multiplyFraction to divide two fractions as well. 
 * @author Shikha
 * 
 */
public class Fraction 
{
	//fields
	private int num, denom;
	
	//constructors
	   public Fraction ( )
	   {
	       this(0,1);
	   }

	   public Fraction(int n)
	   {
		   this(n,1);
	   }  
	   
	   public Fraction(int p, int q)
	   {
	       num = p;
	       denom = q;
	       reduce();
	   }
	   
	   public Fraction(Fraction other)
	   {
	       this(other.num,other.denom);
	   }
	   
	//get and set methods
	   public int getNum() 
	   {
		   return num; 
	   }
	   
	   public int getDenom() 
	   {
		   return denom; 
	   }
	   
	   public void setNum(int a) 
	   {
		   num = a;
		   reduce();
	   }
	   
	   public void setDenom(int a) 
	   {
		   denom = a;
		   reduce();
	   }
	   
	   public void setNumDenom(int a, int b) 
	   {
		   num = a;
		   denom = b;
		   reduce();
	   }
	   
	//methods
	   
	 //methods in question
	   public void reduce() 
	   {
		   int i = 2;
		   while (i<Math.abs(num) && i<denom)
		   {
			 //finding common factors
			   if (denom%i==0 && Math.abs(num)%i==0)
			   { 
				   denom = denom/i;
				   num = num/i;
			   }
			   else 
			   {
				   i++;
			   }
		   }
		   if(num!=0&&denom%num==0)
		   {
			   denom=denom/num;
			   num = 1;
		   }
		   else if(denom!=0&&num%denom==0)
		   {
			   num = num/denom;
			   denom = 1;
		   }
		   if (denom<0)
		   {
			   num = num * -1;
			   denom = denom * -1;
		   }
	   }
	   
	   public void addFraction(Fraction obj)
	   {
		 //finding lcm of denominators
		   if(denom!=obj.denom)
		   {
			   num = num * obj.denom;
			   obj.num = denom * obj.num;
			   denom = denom*obj.denom;
			   obj.denom = denom;
		   }
		   num = num + obj.num;
		   
		   reduce();
	   }
	   
	   public void subtractFraction(Fraction obj)
	   {
		   Fraction obj2 = new Fraction(-(obj.num),obj.denom);//reusing code
		   addFraction(obj2);
	   }
	   
	   public void multiplyFraction(Fraction obj)
	   {
		   num = num * obj.num;
		   denom = denom * obj.denom;
		   reduce();
	   }
	   
	   public void divideFraction(Fraction obj)
	   {
		   Fraction obj2 = new Fraction(obj.denom,obj.num);//reusing code
		   multiplyFraction(obj2);
	   }
	   
	   public void print()
	   {
		   System.out.println(num+"/"+denom);
	   }
}
