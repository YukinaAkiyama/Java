package Box;
import java.util.Scanner;
/**
 * @author 86176
 */
public class Cube {
    private float length;
    private float width;
    private float height;
    Cube(){
        Scanner input = new Scanner(System.in);
        float length = input.nextFloat();
        float width = input.nextFloat();
        float height = input.nextFloat();
        setCube(length,width,height);
        input.close();
    }
    private void setCube(float length,float width,float height){
        this.length = length;
        this.width = width;
        this.height = height;
    }
    float volume(){
        return length*width*height;
    }

    public static void main(String[] args) {
        System.out.println("请用户输入长、宽、高：");
        Cube data1 = new Cube();
        System.out.println("体积为"+data1.volume());
    }

}
