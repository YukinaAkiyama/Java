package Abstract;

/**
 * @author 86176
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("圆");
        Circle circle = new Circle();
        circle.center();
        circle.diameter();
        circle.getArea();
        System.out.println("正方形");
        Square square = new Square();
        square.center();
        square.diameter();
        square.getArea();
    }
}
