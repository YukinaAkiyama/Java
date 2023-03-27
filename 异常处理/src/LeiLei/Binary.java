package LeiLei;

import java.util.Scanner;

public class Binary {
    public void bin2Dec ()throws BinaryFormatException{
        System.out.print("请输入一个二进制数：\n");
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        for(int i=0;i<str.length();i++) {
            if (str.charAt(i) != '0' && str.charAt(i) != '1'){
                throw  new BinaryFormatException();
            }
        }
        System.out.println("正确的二进制数");


    }
}
