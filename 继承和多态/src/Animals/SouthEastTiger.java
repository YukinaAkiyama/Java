package Animals;
/**东南虎
 * @author 86176*/
public class SouthEastTiger extends Animal{
    @Override
    void getCount(int n){
        count=n;
        name ="SouthEastTiger:";
        System.out.println(name+count);
    }
}
