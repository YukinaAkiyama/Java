package P125Q1;

/**
 * @author 86176
 */
public class Main {
	public static void main(String[] args){
		Student a = new Student();
		try{
			a.speak(999);
			a.speak(1001);
		}
		catch(MyException e){
			System.out.println(e.toString());
		}
	}
}
