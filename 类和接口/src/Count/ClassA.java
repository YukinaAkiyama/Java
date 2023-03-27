package Count;

/**
 * @author 86176
 */
public class ClassA implements InterfaceA {
    @Override
    public int method(int n) {
        int sum=0;
        for (int i=1;i<=n;i++){
            sum+=i;
        }
        return sum;
    }
}
