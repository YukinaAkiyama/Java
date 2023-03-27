package FileCreat;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 修改文件内容
 *
 * @return
 */


public class EditFile {
    private static boolean modifyFileContent(String oldstr, String newStr) {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile("word.txt", "rw");
            String line = null;
            // 记住上一次的偏移量
            long lastPoint = 0;
            while ((line = raf.readLine()) != null) {
// 文件当前偏移量
                final long ponit = raf.getFilePointer();
                // 查找要替换的内容
                if (line.contains(oldstr)) {
                    String str = line.replace(oldstr, newStr);
                    System.err.println(str);
                    raf.seek(lastPoint);
                    raf.writeBytes(str);
                }
                lastPoint = ponit;
                System.err.println(lastPoint);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                assert raf != null;
                raf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }
}