package Example10_2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author 86176
 */
public class Example {
    public static void main(String[] args) {
        new Folder();
        File f = new File(Folder.PATH);
        File fi = new File(f, "example.txt");
        try {
            byte[] buffer = new byte[512];
            FileInputStream fis = new FileInputStream(fi);
            int rs = 0;
            System.out.println("The contents of the example is: ");
            while ((rs = fis.read(buffer, 0, 512)) > 0) {
                String s = new String(buffer, 0, rs);
                System.out.println(s);
            }
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}