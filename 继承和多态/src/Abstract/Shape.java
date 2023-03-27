package Abstract;

/**
 * @author 86176
 */

public abstract class Shape {
    int X_axis ,Y_axis;
    double SideLength;
    double PI = 3.14;
    double radius;
    abstract public void center();
    abstract public void diameter();
    abstract public void getArea();
}
