package P125Q2;

/**
 * @author 86176
 */
public class MyException extends Exception{
    String message;
    public MyException() {
        message="Don't enter zero!";
    }

    @Override
    public String toString(){
        return message;
    }
}
