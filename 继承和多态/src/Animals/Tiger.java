package Animals;
/**
 * @author 86176
 */
public class Tiger extends Animal{
    @Override
    void getCount(int n){
        count=n;
        name ="SouthEastTiger:";
        System.out.println(name+count);
    }
}
