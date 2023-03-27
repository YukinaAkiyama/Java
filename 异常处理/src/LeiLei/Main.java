package LeiLei;

public class Main {
    public static void main(String[] args) {
        Binary binary = new Binary();
        try {
            binary.bin2Dec();
        }catch (BinaryFormatException e){
            System.out.println(e.toString());
        }
    }
}
