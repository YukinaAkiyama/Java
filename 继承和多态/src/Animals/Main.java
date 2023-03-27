package Animals;

/**
 * @author 86176
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("！！Welcome to the zoo！！");
        Fish fish = new Fish();
        fish.getCount(101);
        SouthEastTiger SET = new SouthEastTiger();
        SET.getCount(102);
        Tiger tiger = new Tiger();
        tiger.getCount(105);
    }
}
