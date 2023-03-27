package P125Q2;
import java.util.Scanner;

/**
 * @author 86176
 */
public class Number {

	public static void main(String[] args){
		Count count =new Count();
		Scanner input = new Scanner(System.in);
		try{
			System.out.println("Please enter two whole numbers!");
			int m=input.nextInt();
			int n=input.nextInt();
			count.count(m,n);

			System.out.println("\nPlease enter two whole numbers!");
			int o=input.nextInt();
			int p=input.nextInt();
			count.count(o,p);
		}
		catch(Exception e){
			System.out.println(e.toString());
		}
	}
}
