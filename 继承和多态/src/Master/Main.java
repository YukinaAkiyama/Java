package Master;

/**
 * @author 86176
 */
public class Main {
    public static void main(String[] args) {
        Monkey monkey = new Monkey("猴子:");
        monkey.speak();
        People people = new People("人:");
        people.speak();
        people.think();
    }
}
