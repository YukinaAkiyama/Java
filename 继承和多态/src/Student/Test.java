package Student;

/**
 * @author 86176
 */
public class Test {
    public static void main(String[] args) {
        Student student = new Student("Alex",18);
        student.show();
        Undergraduate undergraduate = new Undergraduate("Argenta",17,"Math");
        undergraduate.show();
    }
}
