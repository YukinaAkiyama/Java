package Student;

/**
 * @author 86176
 */
public class Undergraduate extends Student{
    String major;
    public Undergraduate(String Name, int Age,String Major) {
        super(Name, Age);
        major=Major;
    }

    @Override
    public void show(){
        System.out.println("Student's information:");
        System.out.println(name);
        System.out.println(age);
        System.out.println(major);
    }
}
