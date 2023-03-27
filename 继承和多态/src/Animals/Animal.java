package Animals;
import java.util.Scanner;
/**
 * @author 86176
 */
public class Animal {
    Scanner input = new Scanner(System.in);
    String name ="";
    int leg = 0;
    int count = 0;
    void setLeg(){
        leg = input.nextInt();
    }
    int getLeg(){
        return leg;
    }
    void setKind(){
        name = input.nextLine();
    }
    String getKind(){
        return name;
    }
    void getCount(int n){
        count = input.nextInt();
    }
}
