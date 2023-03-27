package P125Q1;

/**
 * @author 86176
 */
public class MyException extends Exception{
	String message;
	public MyException(int n) {
		message="Number cannot be greater than 1000£¡";
	}

	@Override
	public String toString(){
		return message;
	}

}
