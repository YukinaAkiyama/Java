package User类;
import java.util.Objects;
import java.util.Scanner;
/**
 * @author 86176
 */
public class User {
    private String UserName;
    private String Key;
    static Scanner input=new Scanner(System.in);
    User(String username,String key){
        UserName=username;
        Key=key;
    }

    public String setUserName(){
        String ID;
        System.out.println("输入用户名");
        ID=input.nextLine();
        UserName = ID;
        return UserName;
    }

    public String setKey(){
        String key,rightKey;
        while (true){
            System.out.println("输入密码");
            key=input.nextLine();
            System.out.println("确认密码");
            rightKey = input.nextLine();
            if(!Objects.equals(key, rightKey)){
                System.out.println("两次密码不同");
            }
            else { break;}
        }
        Key = key;
        return Key;
    }

    public void display(){
        System.out.println("用户名: " + UserName);
        System.out.println("密码: " + Key);
    }

    public static void main(String[] args){
        User user = new User(null, null);
        user.setUserName();
        user.setKey();
        System.out.println("用户信息：");
        user.display();
        System.out.println("是否需要更改密码？\n更改请按Y键\n否则按其他");
        String choice,s1="Y",s2="y";
        choice=input.nextLine();
        if(choice.equals(s1) || choice.equals(s2) ){
            user.setKey();
            System.out.println("更改成功");
        }
        input.close();
    }
}
