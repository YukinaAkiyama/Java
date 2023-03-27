package MyInformation;

/**
  实现文件的读取和写入
  @author 86176
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Main {
    public static void main(String[] args) {
        File f=new File("D:\\Java项目\\输入和输出\\src\\MyInformation\\abc.txt");
        try {
            FileOutputStream out=new FileOutputStream(f);
            String information="学号：10086\r\n姓名：中国移动\r\n谨防移动支付陷阱！";
            byte[] b=information.getBytes();
            out.write(b);
            out.close();
            FileInputStream in=new FileInputStream(f);
            byte[] b1=new byte[1024];
            int i=-1;
            StringBuilder str=new StringBuilder();
            while((i=in.read(b1))>0)
            {
                str.append(new String (b1,0,i));
            }
            in.close();
            System.out.println(str);
        } catch (Exception e) {
// TODO 自动生成的 catch 块
            e.printStackTrace();
        }
    }
}