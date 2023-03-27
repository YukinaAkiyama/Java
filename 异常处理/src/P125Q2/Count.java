package P125Q2;


/**
 * @author 86176
 */
public class Count {

    public void count(int i,int j)throws MyException{
        if(i==0 || j==0){
            throw new MyException();
        }else {
            int sum = i * j;
            System.out.print("The answer is:  " + sum);
        }
    }
}
