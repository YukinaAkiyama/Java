package PhoneNumberCheak;

public class CheckException extends Exception{
    String message;
    CheckException(){
        message="The phone number is in the wrong format, please re-enter!";
    }
    @Override
    public String toString(){
        return message;
    }
}
