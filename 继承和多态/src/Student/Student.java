package Student;

/**
 * @author 86176
 */
public class Student {
    String name;
    int age;
    public Student(String Name,int Age){
        name=Name;
        age=Age;
    }


    public void show(){
        System.out.println("Student's information:");
        System.out.println(name);
        System.out.println(age);
    }
}
