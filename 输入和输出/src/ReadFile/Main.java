package ReadFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author 86176
 */
public class Main {
    public static void main(String[] args) {
        File file = new File("demo.txt");
        long past = System.currentTimeMillis();
        long now;
        int[] group = new int[52];
        int result = 0;
        try {
            FileInputStream fis = new FileInputStream(file);
            byte[] buf = new byte[1];
            int rs;
            while ((rs=fis.read(buf))>0) {
                String tmp = new String(buf, 0, rs);
                if(tmp.compareTo("a") >= 0 && tmp.compareTo("z") <= 0) {
                    group[tmp.compareTo("a")]++;
                } else if(tmp.compareTo("A") >= 0 && tmp.compareTo("Z") <= 0) {
                    group[26 + tmp.compareTo("A")]++;
                }
            }
            System.out.println();
            for(int i = 0; i < group.length; i++) {
                if(group[result] < group[i]) {
                    result = i;
                }
            }
            now = System.currentTimeMillis();
            if(result > 25) {
                System.out.println("The most frequent letter is " + (char)(result -26 +'A'));
            } else {
                System.out.println("The most frequent letter is " + (char)(result+'a'));
            }
            System.out.println("It appears " + group[result] + " times.");
            System.out.println("It takes " + (now-past) + "ms.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
