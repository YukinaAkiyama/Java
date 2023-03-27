package Animals;
/**
 * @author 86176
 */
public class Fish extends Animal{
    @Override
    void getCount(int n){
        count=n;
        name ="Fish:";
        System.out.println(name+count);
    }
}
