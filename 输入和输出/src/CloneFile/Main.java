package CloneFile;

import java.io.*;

/**
 * @author 86176
 */
public class Main {

    public static void main(String[] args) throws IOException {
        File f1 = new File("D:\\Java项目\\输入和输出\\src\\CloneFile\\source.txt");
        File f2 = new File("D:\\Java项目\\输入和输出\\src\\CloneFile\\destination.txt");

        try {
            FileInputStream fis = new FileInputStream(f1);
            FileOutputStream fos = new FileOutputStream(f2);

            byte[] temp = new byte[100];//定义一个字节数组
            fis.read(temp);//读到内存中
            fos.write(temp);//写到文件

            fis.close();
            fos.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("运行结束");
    }
}