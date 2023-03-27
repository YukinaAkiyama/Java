package Guess;
import java.util.Random;
import java.util.Scanner;

/**
 * @author 86176
 */
public class Main {
    public static void startGame(int n){
        Scanner input = new Scanner(System.in);
        System.out.println("Please guess the random number:");
        for (int i = 1;i<2147483647;i++){
            int guess= input.nextInt();
            if (guess<n){
                System.out.println("Maybe you should enter a larger number：");
            }else if (guess>n){
                System.out.println("Maybe you should enter a smaller number：");
            }else {
                System.out.println("The input is correct and the number is: "+guess+"\nNumber of games:"+i);
                break;
            }
        }
    }

    public static void main(String[] args) {
        Random RD = new Random();
        int x = RD.nextInt(100);
        System.out.println("The random number was created successfully, with a range of 0-100!");
        startGame(x);
    }
}
