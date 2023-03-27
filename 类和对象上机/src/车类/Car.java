//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package 车类;
import java.util.Scanner;

/**
 * @author 86176
 */
public class Car {
    /**速度浮点数**/
    private float velocity;
    /**体积浮点数**/
    private float volume;

    Car(float speed, float size) {
        this.velocity = speed;
        this.volume = size;
    }

    public float setSpeed(float speed) {
        this.velocity = speed;
        return this.velocity;
    }

    public float getSpeed() {
        return this.velocity;
    }

    public float SpeedUp(float speed) {
        this.velocity += speed;
        return this.velocity;
    }

    public float SpeedDown(float speed) {
        this.velocity -= speed;
        return this.velocity;
    }

    public float setSize(float length, float width, float height) {
        this.volume = length * width * height;
        return this.volume;
    }

    public float getSize() {
        return this.volume;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Car car = new Car(0.0F, 0.0F);
        System.out.println("输入初速：(单位：米/秒)");
        float speed = input.nextFloat();
        car.setSpeed(speed);
        System.out.println("初速度  " + car.getSpeed() + "米/秒");
        System.out.println("输入长、宽、高：（单位：米）");
        System.out.println("输入长：");
        float length = input.nextFloat();
        System.out.println("输入宽：");
        float width = input.nextFloat();
        System.out.println("输入高：");
        float height = input.nextFloat();
        car.setSize(length, width, height);
        System.out.println("体积  " + car.getSize() + "立方米");
        System.out.println("加速  10:\n速度：" + car.SpeedUp(10.0F) + "米/秒");
        System.out.println("减速  20:\n速度：" + car.SpeedDown(20.0F) + "米/秒");
        input.close();
    }
}
