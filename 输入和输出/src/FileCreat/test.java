package 记事本小程序;

import java.io.*;
import java.util.Scanner;
public class test {
    private static String filePath;
    private static String message = "";

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("---------日记本---------");
            System.out.println("1.新建文件");
            System.out.println("2.打开文件");
            System.out.println("3.修改日记");
            System.out.println("4.保存");
            System.out.println("5.退出");
            System.out.println("注意：每次输入内容后记得保存！");
            System.out.print("请输入操作指令：");
            int command = sc.nextInt();
            switch (command) {
                case 1:
                    createFile();
                    break;
                case 2:
                    openFile();
                    break;
                case 3:
                    editFile();
                    break;
                case 4:
                    saveFile();
                    break;
                case 5:
                    System.out.println("谢谢使用本系统，欢迎下次再来！");
                    System.exit(0);
                    break;
                default:
                    System.out.println("您输入的指令错误！");
                    break;
            }
        }
    }

    private static void createFile() {
        message = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入内容，停止编写请输入：stop");
        StringBuffer stb = new StringBuffer();
        String inputMessage = "";
        while (!inputMessage.equals("stop")) {
            if (stb.length() > 0) {
                stb.append("\r\n");
            }
            stb.append(inputMessage);
            inputMessage = sc.nextLine();
        }
        message = stb.toString();
    }

    private static void saveFile() throws Exception {
        FileWriter out = new FileWriter("文件路径", true);
        out.write(message + "\r\n");
        message = "";
        out.close();
    }

    public static void openFile() throws Exception {
        Reader r = new FileReader("文件路径");
        BufferedReader br = new BufferedReader(r);
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }

    public static void editFile() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("原文件内容：");
        String str1 = sc.next();
        System.out.println("修改成：");
        String str2 = sc.next();
        File file = new File("文件路径");
        FileReader in = new FileReader(file);
        BufferedReader buf = new BufferedReader(in);
        CharArrayWriter tempStream = new CharArrayWriter();
        String line = null;
        while ((line = buf.readLine()) != null) {
            line = line.replaceAll(str1, str2);
            tempStream.write(line + "\r\n");
        }
        buf.close();
        FileWriter fw = new FileWriter(file);
        tempStream.writeTo(fw);
        fw.close();
    }
}
