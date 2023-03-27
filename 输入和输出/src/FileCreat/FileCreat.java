package FileCreat;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class FileCreat {
    private static String message = "";
	static int num = 0;
	static String dateStr;
	static SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");


	public static void main(String[] args) throws Exception {
		// TODO 自动生成的方法存根
		File file=new File("word.txt");//创建记事本
		if(file.exists()) {
			System.out.println("记事本已创建！");
		}else {
			try {
				file.createNewFile();
				System.out.println("记事本已创建！");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.println("---------记事本小程序---------");
		System.out.println("1.写入记事内容");
		System.out.println("2.打开记事本");
		System.out.println("3.修改记事本内容");
		System.out.println("4.保存");
		System.out.println("5.查询日期（格式：yyyy-MM-dd）所做的事");
		System.out.println("6.退出");
		System.out.println("注意：每次输入内容后记得保存！");
		System.out.print("请输入操作指令：");
        while (true) {
            int num = sc.nextInt();
            switch (num) {
                case 1:
                    WriteFile();
                    break;
                case 2:
                    openFile();
                    break;
                case 3:
                    editFile();
                    break;
                case 4:
                    inFile();
                    break;
                case 5:
                	ByDay();
                	break;
                case 6:
                    System.out.println("谢谢使用该记事本，欢迎下次再来！");
                    System.exit(0);
                    break;
                default:
                    System.out.println("您输入的指令错误！");
                    break;
            }
	     }
	}
	
	
	private static void WriteFile() {
        message = "";
		StringBuffer stb = new StringBuffer();
		Scanner sc = new Scanner(System.in);
        System.out.println("请输入日期（格式：yyyy-MM-dd）：");
        String date= sc.nextLine();
		System.out.println("请输入内容(停止编写请输入stop):");
        String content = "";
        while (!Objects.equals(content, "stop")) {
            if (stb.length() > 0) {
                stb.append("\r\n");
            }
			stb.append(date);
            stb.append("  ").append(content);
            content = sc.nextLine();
        }
		message = stb.toString();
		System.out.println("已停止输入，请选择其他选项");
    }
	
	
	
	public static void openFile() throws Exception {
		File file=new File("word.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line=null;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }
	
	
	public static void editFile() throws IOException {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("修改内容的日期（格式：yyyy-MM-dd）：");
	        String date1 = sc.nextLine();
	        System.out.println("修改的内容为：");
	        String str1 = sc.next();
	        System.out.println("内容修改成：");
	        String str2 = sc.next();
	        File file=new File("word.txt");
	        FileReader fr1 = new FileReader(file);
	        BufferedReader br1 = new BufferedReader(fr1);
	        CharArrayWriter tempStream = new CharArrayWriter();
	        String line = null;
	        while ((line = br1.readLine()) != null) {
	            line = line.replaceAll(str1, str2);
	            tempStream.write(line + "\r\n");
	        }
	        br1.close();
	        FileWriter fw = new FileWriter(file);
	        tempStream.writeTo(fw);
	        fw.close();
	    }
	 
	 
	private static void inFile() throws Exception {
		FileWriter in = new FileWriter("word.txt", true);
		in.write(message + "\r\n");
		message = "";
		in.close();
		System.out.println("保存成功！");
	}
	public static void ByDay() {
		try {
			System.out.println("请输入查询的日期：（格式：yyyy-MM-dd）");
			Scanner input = new Scanner(System.in);
			dateStr=input.nextLine();
			boolean dateflag=true;
			while (true){
				try
				{
					Date date = format.parse(dateStr);
				} catch (ParseException e)
				{
					dateflag=false;
				}
				if(dateflag)break;
				System.out.println("日期是否满足要求 "+dateflag+"（ 正确格式：yyyy-MM-dd）");
				dateStr=input.nextLine();
				dateflag=true;
			}

			File file=new File("word.txt");
			FileReader flr=new FileReader(file);
			BufferedReader bfr = new BufferedReader(flr);
			String line;
			while ((line = bfr.readLine()) != null) {
				// 判断记录中的日期是否符合要求
				if (line.contains(dateStr)) {
					System.out.println(line);
					num++;
				}
				if(num == 0){
					System.out.println("该日期不存在！");
					num++;
				}
			}
			bfr.close();
			flr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
