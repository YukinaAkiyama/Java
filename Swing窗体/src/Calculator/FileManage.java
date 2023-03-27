package Calculator;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author 86176
 */
public class FileManage{
    protected String pathName = "计算数据.txt";
    private final File file = new File(pathName);

    public FileManage(){
    }
    public void saveFile(String saveData){
        FileWriter fileWriter;
        //存放上次保存的文件信息
        String oldData = showFile();
        try {
            fileWriter = new FileWriter(file);
            assert fileWriter != null;
            //覆盖上次保存的文件信息并写入上次和此次需保存的信息
            fileWriter.write(oldData+saveData);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String showFile() {
        StringBuilder dataFileOutput = null;
        try (FileReader fileReader = new FileReader(file)) {
            // 一次性取多少个字节
            char[] chars = new char[1024];
            // 用来接收读取的字节数组
            dataFileOutput = new StringBuilder();
            // 读取到的字节数组长度，为-1时表示没有数据
            int length;
            // 循环取数据
            while ((length = fileReader.read(chars)) != -1) {
                // 将读取的内容转换成字符串
                dataFileOutput.append(chars, 0, length);
            }
            // 关闭流
        } catch (IOException e) {
            e.printStackTrace();
        }
        return String.valueOf(dataFileOutput);
    }

    public void clearFile() {
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(file);
            //覆盖并写入空值
            fileWriter.write("");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
