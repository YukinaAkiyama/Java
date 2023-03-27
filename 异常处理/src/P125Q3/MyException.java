package P125Q3;

/**
 * @author 86176
 */
public class MyException extends Exception{
	String message;
	MyException(){
		message="The number entered contains a negative integer!";
	}
	@Override
	public String toString(){
		return message;
	}
}
