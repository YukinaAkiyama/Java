package LeiLei;

public class BinaryFormatException extends Exception {
    String message;
    BinaryFormatException() {
        message="这不是二进制数";
    }

    @Override
    public String toString(){
        return message;
    }
}
