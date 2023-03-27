package Abstract;
import java.util.Scanner;

/**
 * @author 86176
 */
public class Circle extends Shape{
    Circle(){
        Scanner input = new Scanner(System.in);
        System.out.println("圆心横坐标：");
        X_axis = input.nextInt();
        System.out.println("圆心纵坐标");
        Y_axis = input.nextInt();
        System.out.println("半径");
        radius = input.nextDouble();
    }
    @Override
    public void center() {
        System.out.println("圆心坐标："+"("+X_axis+","+Y_axis+")");
    }

    @Override
    public void diameter() {
        System.out.println("周长："+2*PI*radius);
    }

    @Override
    public void getArea() {
        System.out.println("面积："+PI*radius*radius+"\n");
    }
}
