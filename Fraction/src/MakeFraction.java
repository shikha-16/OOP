import java.util.Scanner;
/**
 * This program is for making the fraction.
 * @author shikha
 * 
 * 
 */
public class MakeFraction {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter numerator: ");
		int n1 = sc.nextInt();
		System.out.println("Enter denominator: ");
		int d1 = sc.nextInt();
		
		while(d1==0) 
		{
			System.out.println("Please enter a non-zero value as denominator");
			d1 = sc.nextInt();
		}
		
		Fraction f1 = new Fraction();
		
		//to print reduced fraction
		f1.setNum(n1);
		f1.setDenom(d1);
		System.out.print("The entered fraction is: ");
		f1.print();
		
		//to test addition, subtraction, multiplication and division
		System.out.println("Enter the next fraction");
		System.out.println("Enter numerator: ");
		int n2 = sc.nextInt();
		System.out.println("Enter denominator: ");
		int d2 = sc.nextInt();
		
		while(d2==0) 
		{
			System.out.println("Please enter a non-zero value as denominator");
			d2 = sc.nextInt();
		}
		
		Fraction f2 = new Fraction();
		
		//to print reduced fraction
		f2.setNum(n2);
		f2.setDenom(d2);
		System.out.print("The entered fraction is: ");
		f2.print();
		
		System.out.println("Please enter operator: ");
		char op = sc.next().charAt(0);
		
		switch(op)
        {
            case '+':
            {
                f1.addFraction(f2);
                System.out.print("Addition: ");
        		f1.print();
                break;
            }
            case '-':
            {
                f1.subtractFraction(f2);
                System.out.print("Subtraction: ");
        		f1.print();
                break;
            }
            case '*':
            {
                f1.multiplyFraction(f2);
                System.out.print("Multiplication: ");
        		f1.print();
                break;
            }
            case '/':
            {
                f1.divideFraction(f2);
                System.out.print("Division: ");
        		f1.print();
                break;
            }
            default:
            {
				System.out.println("Incorrect operator.");
            }
		}
	
		sc.close();
		
	}

}
