package FinallyProject;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author 86176
 */
public class Book {
    private int bookid;
    static int id = 2021001000;
    public String name;
    public String author;
    public double price;
    public String place;
    public Scanner scan;
    public Book(){
        this.scan = new Scanner(System.in);
    }
    public Book(String name,String author,double price,String place){
        this.bookid=++id;
        this.name=name;
        this.author=author;
        this.price=price;
        this.place=place;
    }
    public void menu(){
        System.out.println("+++++欢迎使用图书管理系统+++++++++++++++");
        System.out.println("+++++1.查询某本图书信息++++++++++++++++");
        System.out.println("+++++2.找出定价最高的书++++++++++++++++");
        System.out.println("+++++3.统计书的总数+++++++++++++++++++");
        System.out.println("+++++4.修改图书信息，返回新的图书信息+++++");
        System.out.println("+++++5.添加新的图书，返回新的图书信息+++++");
        System.out.println("+++++6.删除指定图书，返回新的图书信息+++++");
        System.out.println("+++++7.退出++++++++++++++++++++++++++");
    }

    public int getId(){
        return bookid;
    }
    public String getName(){return name;}
    public void setName(String name){this.name=name;}
    public String getAuthor(){return author;}
    public void setAuthor(String author){this.author=author;}
    public double getPrice(){return price;}
    public void setPrice(double price){this.price=price;}
    public String getPlace(){return place;}
    public void setPlace(String place){this.place=place;}


    @Override
    public String toString(){
        return "书的编号："+bookid+"\t\t名字："+name+"\t\t作者："+author+"\t\t价格："+price+"\t\t位置："+place;
    }

    void play() {
        Manage newMan = new Manage();
        while (true) {
            menu();
            System.out.print("请选择操作\n");
            int num = scan.nextInt();
            switch (num) {
                case 1:
                    newMan.queryBook();
                    System.out.println("按任意键继续");
                    try {
                        System.in.read();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    newMan.highestBook();
                    System.out.println("按任意键继续");
                    try {
                        System.in.read();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    newMan.totalBook();
                    System.out.println("按任意键继续");
                    try {
                        System.in.read();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    newMan.alterBook();
                    System.out.println("按任意键继续");
                    try {
                        System.in.read();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    newMan.add();
                    System.out.println("按任意键继续");
                    try {
                        System.in.read();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 6:
                    newMan.deleteBook();
                    System.out.println("按任意键继续");
                    try {
                        System.in.read();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 7:
                    System.out.println("成功退出系统!");
                    //程序正常退出
                    System.exit(0);
                default:
                    System.out.println("无效的输入，请从新输入:");
                    System.out.println("按任意键继续");
                    try {
                        System.in.read();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }
}