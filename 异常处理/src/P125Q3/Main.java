package P125Q3;

/**
 * @author 86176
 */
public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer();
        try{
            computer.commonDivisor(23,34);
            computer.commonDivisor(12,24);
            computer.commonDivisor(-23,-34);
        }
        catch(MyException e){
            System.out.println(e);
        }
    }
}
