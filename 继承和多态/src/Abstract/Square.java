package Abstract;
import java.util.Scanner;
/**
 * @author 86176
 */
public class Square extends Shape {
    Square(){
        Scanner input = new Scanner(System.in);
        System.out.println("中心横坐标：");
        X_axis = input.nextInt();
        System.out.println("中心纵坐标");
        Y_axis = input.nextInt();
        System.out.println("周长");
        SideLength = input.nextDouble();
    }
    @Override
    public void center() {
        System.out.println("中心坐标："+"("+X_axis+","+Y_axis+")");
    }

    @Override
    public void diameter() {
        System.out.println("周长："+4*SideLength);
    }

    @Override
    public void getArea() {
        System.out.println("面积："+SideLength*SideLength+"\n");
    }
}
