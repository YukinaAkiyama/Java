package Complex_number;

import java.util.Scanner;

/**
 * @author 86176
 */
class Test { // 用于测试复数类

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        System.out.println("请用户输入第一个复数的实部和虚部:");
        Complex data1 = new Complex();
        System.out.println("请用户输入第二个复数的实部和虚部:");
        Complex data2 = new Complex();

        Complex resultAdd = data1.add(data2);
        Complex resultSub = data1.sub(data2);
        Complex resultMul = data1.mul(data2);
        Complex resultDiv = data1.div(data2);

        System.out.println("相加：");
        resultAdd.print();
        System.out.println("相减：");
        resultSub.print();
        System.out.println("相乘：");
        resultMul.print();
        System.out.println("相除：");
        resultDiv.print();

        System.out.println("请用户输入要求模的复数的实部和虚部:");
        Scanner input = new Scanner(System.in);
        double real = input.nextDouble();
        double image = input.nextDouble();
        Complex dataAbs = new Complex(real,image);
        Complex resultAbs = dataAbs.div(dataAbs);
        System.out.println("求模：");
        resultAbs.print();

    }
}