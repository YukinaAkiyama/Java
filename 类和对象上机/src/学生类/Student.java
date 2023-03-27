package 学生类;
import java.util.Scanner;
/**
 * @author 86176
 */
public class Student {
    private String Name;
    private String StudentID;
    Student(String name,String studentID){
        Name=name;
        StudentID=studentID;
    }
    public void display(){
        System.out.println("Student: " + Name);
        System.out.println("Number: " + StudentID);
    }
    public void change(String Name,String StudentID){
        System.out.println("成功更改姓名为"+Name);
        System.out.println("成功更改学号为"+StudentID);
    }
    public static void main(String[] args){
        String Name,StudentID;
        Scanner input=new Scanner(System.in);
        System.out.println("输入姓名");
        Name=input.nextLine();
        System.out.println("输入学号");
        StudentID=input.nextLine();
        Student student = new Student(Name,StudentID);
        System.out.println("学生信息：");
        student.display();
        System.out.println("是否需要更改信息？\n更改请按Y键\n否则按其他");
        String choice,s1="Y",s2="y";
        choice=input.nextLine();
        if(choice.equals(s1) || choice.equals(s2) ){
            System.out.println("输入姓名");
            Name=input.nextLine();
            System.out.println("输入学号");
            StudentID=input.nextLine();
            student.change(Name,StudentID);
        }
        input.close();
    }
}
