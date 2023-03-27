package P125Q1;

/**
 * @author 86176
 */
public class Student {
	public void speak(int n)throws MyException{
		if(n>1000){
			throw new MyException(n);
		}
		System.out.println("I can speak "+n+" words in 3 minutes.");
	}
}
