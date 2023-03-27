package question_5;

public class 五题{
    public static void main(String[] args) {
        int i,j;
        System.out.println("100以内素数");
        for(i=2;i<=100;i++) {
            for(j=2;j<=i/2;j++) {
                if(i%j==0) {
                    break;
                }
            }
            if(j>i/2) {
                System.out.println(i);
            }
        }
    }
}