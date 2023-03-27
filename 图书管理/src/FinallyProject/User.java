package FinallyProject;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author 26245
 */
public class User {
    private String username;
    private String pwd;
    static ArrayList<User> list = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    static {
        list.add(new User("jack", "11111111"));
        list.add(new User("rose", "22222222"));
        list.add(new User("lucy", "33333333"));
    }

    public User(){}  //无参构造方法，用于创建对象调用方法

    public User(String username, String pwd) {   //含参构造方法，用于创建用户信息
        this.username = username;  //对对象数据进行定义
        this.pwd = pwd;
    }

    public String getUsername() {
        return username;
    }

    public String getPwd() {
        return pwd;
    }

    public static void stopScan(){
        /*1.阻塞方法，程序此时停止执行，等待标准输入设备输入一行数据，用户回车后方法调用完成，程序继续向下执行
          2.input.nextLine()会返回你输入的数据，通常会定义一个变量接收此数据。
         */
        System.out.println("按任意键继续");
        input.nextLine();
    }
    public String loginCheck(User user) {
        String message = "";
        String n = user.getUsername();
        String p = user.getPwd();
        for (User u : list) {
            String name = u.getUsername();
            String pwd = u.getPwd();
            if (name.equals(n)) {
                if (pwd.equals(p)) {
                    System.out.println("登录成功！");
                    Book book = new Book();
                    book.play();
                }
                else {
                    return "登录失败，密码错误！";
                }
            } else {
                message = "用户名不存在";
            }
        }
        return message;
    }

    public void login(){
        while(true){
            System.out.println("1. 注册用户\n2. 登陆\n3. 退出");
            int choice = input.nextInt();
            input.nextLine();
            switch (choice ){
                case 1:
                    System.out.println("输入用户名：");
                    String username = input.nextLine();
                    System.out.println("请输入密码：");
                    String password = input.nextLine();
                    list.add(new User(username, password));
                    stopScan();
                    break;
                case 2:
                    System.out.println("请输入用户名: ");
                    String userName = input.nextLine();
                    System.out.println("请输入密码: ");
                    String passWord = input.nextLine();
                    User user = new User(userName, passWord);
                    String login = loginCheck(user);
                    System.out.println("登录结果: " + login);
                    stopScan();
                    break;
                case 3:
                    stopScan();
                    input.close();
                    System.exit(1);
                    break;
                default:
                    System.out.println("输入错误，请重新选择！");
                    stopScan();
                    break;

            }
        }
    }
}
