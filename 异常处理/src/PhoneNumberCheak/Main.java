package PhoneNumberCheak;



import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static String name;
    static int age;
    static String phoneNumber;
    static boolean checkBool;
    public static void main(String[] args) throws CheckException {
        InsertInfo insertInfo = new InsertInfo();
        System.out.println("Please enter name:");
        name = input.nextLine();
        System.out.println("Please enter age:");
        age = input.nextInt();
        System.out.println("Please enter phone number:");
        phoneNumber = input.nextLine();
        phoneNumber = input.nextLine();
        try {
            checkBool = insertInfo.addInfo(name,age,phoneNumber);
        }catch (CheckException e){
            System.out.println(e.toString());
        }
        while (!checkBool){
            System.out.println("Please enter name:");
            name = input.nextLine();
            System.out.println("Please enter age:");
            age = input.nextInt();
            System.out.println("Please enter phone number:");
            phoneNumber = input.nextLine();
            phoneNumber = input.nextLine();
            try {
                checkBool = insertInfo.addInfo(name,age,phoneNumber);
            }catch (CheckException e){
                System.out.println(e.toString());
            }
        }
    }
}
