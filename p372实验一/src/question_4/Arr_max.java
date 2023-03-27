package question_4;

public class Arr_max{
	public static void main(String[] args) {
		int paixu [] = {2,3,4,6,7,8,1,5,9,12,15,16,11};
		int max,i,j,p=0;
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
		System.out.println("最大值下标   "+ (p+1));
	
	}

}
