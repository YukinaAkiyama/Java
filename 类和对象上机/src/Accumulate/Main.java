package Accumulate;

import java.lang.Math;
/**
 * @author 13947
 */
public class Main {
    static double tripleRoot(double n){
        double l = -10000,r = 10000;
        while(r - l > 1e-8) {
            double mid = (l + r) / 2;
            if(mid*mid*mid >= n) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return r;
    }
    public static void main(String[] args) {

        double a,b,c,sum=0;
        int times = 101;

        for (int n=1;n<times;n++){
            a = Math.pow(n,3);
            b = tripleRoot(n);
            c = a - b;
            sum += c;
        }

        System.out.printf("%.6f",sum);
    }
}
