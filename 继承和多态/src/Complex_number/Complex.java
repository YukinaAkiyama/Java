package Complex_number;
import java.util.Scanner;

/**
 * @author 86176
 */
public class Complex implements Calculation{
    /**复数类*/
    double real;
    /**实部*/
    double image;
    /**虚部*/

    Complex(){  // 不带参数的构造方法
        Scanner input = new Scanner(System.in);
        double real = input.nextDouble();
        double image = input.nextDouble();
        setComplex(real,image);
    }

    private void setComplex(double real, double image) { // 供不带参数的构造方法调用
        // TODO Auto-generated method stub
        this.real = real;
        this.image = image;
    }

    Complex(double real,double image){ // 带参数的构造方法
        this.real = real;
        this.image = image;
    }

    public double getReal() {
        return real;
    }
    public double getImage() { return image; }

    Complex add(Complex a){ // 复数相加
        double real2 = a.getReal();
        double image2 = a.getImage();
        double newReal = real + real2;
        double newImage = image + image2;
        return new Complex(newReal,newImage);
    }

    Complex sub(Complex a){ // 复数相减
        double real2 = a.getReal();
        double image2 = a.getImage();
        double newReal = real - real2;
        double newImage = image - image2;
        return new Complex(newReal,newImage);
    }

    Complex mul(Complex a){ // 复数相乘
        double real2 = a.getReal();
        double image2 = a.getImage();
        double newReal = real*real2 - image*image2;
        double newImage = image*real2 + real*image2;
        return new Complex(newReal,newImage);
    }

    Complex div(Complex a){ //复数相除
        double real2 = a.getReal();
        double image2 = a.getImage();
        double newReal = (real*real2 + image*image2)/(real2*real2 + image2*image2);
        double newImage = (image*real2 - real*image2)/(real2*real2 + image2*image2);
        return new Complex(newReal,newImage);
    }

    //求模
    public static double abs(Complex a) {
        return Math.sqrt(a.real * a.real + a.image * a.image);
    }


    public void print(){ // 输出
        if(image > 0){
            System.out.println(real + " + " + image + "i");
        }else if(image < 0){
            System.out.println(real + "" + image + "i");
        }else{
            System.out.println(real);
        }
    }

    @Override
    public void add() {

    }

    @Override
    public void substrate() {

    }

    @Override
    public void multiply() {

    }

    @Override
    public void divide() {

    }

    @Override
    public void abs() {

    }
}