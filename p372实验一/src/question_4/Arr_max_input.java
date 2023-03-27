package question_4;
import java.util.Scanner;

public class Arr_max_input {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int paixu [] = new int[10];
		
		int max,i,j,p=0;
		
		System.out.println("输入十个整型");
		for(i=0;i<10;i++) {
			System.out.println("请输入第"+(i+1)+"个");
			paixu[i]=input.nextInt();
		}
		
		max=paixu[0];
		j=paixu.length;
		System.out.println("数组长度     "+paixu.length);
		for(i=0;i<j;i++) {
			if(max<paixu[i]) {
				max=paixu[i];
				p=i;
			}		
		}
		//p=p+1;
		System.out.println("数组最大值   "+max);
		System.out.println("最大值下标   "+(p+1));
		input.close();
	
	}

}
