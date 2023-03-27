package Count;
import java.util.Scanner;
/**
 * @author 86176
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter an integer n to calculate the sum of 1 to n and the factorial of n:");
        int N=input.nextInt();
        InterfaceA a=new ClassA();
        System.out.println("Sum:"+a.method(N));
        InterfaceA b=new ClassB();
        System.out.println("Factorial:"+b.method(N));
    }
}
