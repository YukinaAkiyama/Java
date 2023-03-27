package Count;

/**
 * @author 86176
 */
public class ClassB implements InterfaceA{
    @Override
    public int method(int n) {
        int product =1;
        for (int i=1;i<=n;i++){
            product*=i;
        }
        return product;
    }
}
