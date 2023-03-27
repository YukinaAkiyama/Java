package P125Q3;

/**
 * @author 86176
 */
public class Computer {
	public void commonDivisor(int i,int j)throws MyException{
		if(i<0 || j<0){
			throw new MyException();
		}
		int min= Math.min(i, j);
		for(int t=min;t>=1;t--){
			if(i %t==0 && j %t==0){
				System.out.println("Highest common divisor:"+t);
				break;
			}
		}
	}
}
