package FinallyProject;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author 26245
 */
public class Manage {
   Scanner input = new Scanner(System.in);

   ArrayList<Book> bookList = new ArrayList<>();
   {
      Book book1 = new Book( "《三国演义》", "罗贯中 ", 66.5, "名著-A101");
      Book book2 = new Book( "《儒林外史》", "吴敬梓 ", 100.0,"古典-A208");
      Book book3 = new Book( "《朝花夕拾》", "鲁  迅 ", 50.0, "散文集-H405");
      Book book4 = new Book( "《吕氏春秋》", "吕不韦 ", 49.9, "名著-H405");
      Book book5 = new Book( "《C++程序设计》", "谭浩强 ", 72.0, "学习-B201");
      Book book6 = new Book( "《百年孤独》", "加尔列夫", 40.0, "国外小说—C302");
      bookList.add(book1);
      bookList.add(book2);
      bookList.add(book3);
      bookList.add(book4);
      bookList.add(book5);
      bookList.add(book6);
   }
   public void queryBook(){
      System.out.println("输入书籍名字：");
      String name = input.next();
      for(int i = 0;i< bookList.size();i++){
         Book book = bookList.get(i);
         if(name.equals(book.getName())){
            System.out.println(bookList.get(i));
            break;
         }else if (i>=bookList.size()-1){
            System.out.println("暂无此书！");
         }
      }
   }
   public void highestBook(){
      System.out.println("定价最高的书：");
      Book highestBook = bookList.get(0);
      double highestPrice = highestBook.getPrice();
      for(int i=0;i< bookList.size();i++){
         Book compareBook = bookList.get(i);
         double comparePrice = compareBook.getPrice();
         if(comparePrice > highestPrice){
            highestPrice = comparePrice;
            System.out.println(compareBook.name + "\t价格："+compareBook.price);
         }
      }
   }
   public void totalBook(){
      int sum = bookList.size();
      System.out.println("当前图书馆还有"+sum+"本书");
   }
   public void alterBook(){
      System.out.println("输入修改图书的编号：");
      System.out.println("id:");
      int id= input.nextInt();
      input.nextLine();
      System.out.println("请输入新书的名字：");
      String newName =input.nextLine();
      System.out.println("请输入新书的作者：");
      String newAuthor = input.nextLine();
      System.out.println("请输入新书的价格：");
      double newPrice = input.nextDouble();
      input.nextLine();
      System.out.println("请输入新书的位置：");
      String newPlace = input.nextLine();
      for(int i=0;i< bookList.size();i++){
         Book book = bookList.get(i);
         if(id==book.getId()){
            book.setName(newName);
            book.setAuthor(newAuthor);
            book.setPrice(newPrice);
            book.setPlace(newPlace);
            System.out.println("修改成功！");
            for (int a = 0; a < bookList.size(); a++) {
               System.out.println(bookList.get(a));
            }
         }
      }
   }
   public void add(){
      System.out.println("输入图书信息：");
      //System.out.println("id：");
      //int id = input.nextInt();
      /*input.nextLine()消除多余的回车，因为nextIn()方法会把输入分流 只读出解析出的int
       没读出回车，之后的nextLine()方法会直接读到没读的回车就直接输出了*/
      input.nextLine();
      System.out.println("书名：");
      String name =input.nextLine();
      System.out.println("作者：");
      String author = input.nextLine();
      System.out.println("价格：");
      double price = input.nextDouble();
      input.nextLine();
      System.out.println("位置：");
      String place = input.nextLine();
      Book newBook = new Book(name,author,price,place);
      bookList.add(newBook);
      for (int i = 0; i < bookList.size(); i++) {
         System.out.println(bookList.get(i));
      }
   }

   public void deleteBook() {
      System.out.println("输入书籍编号，格式为2021001***：");
      int id = input.nextInt();
      for (int i = 0; i < bookList.size(); i++) {
         Book book = bookList.get(i);
         if (id == book.getId()) {
            bookList.remove(book);
            System.out.println("删除成功");
            System.out.println("删除后还有以下书籍：");
            for (int j = 0; j < bookList.size(); j++){
               System.out.println(bookList.get(j));
            }
            break;
         }else if(i==bookList.size()){
            System.out.println("失败，库中未找到该书");
            break;
         }
      }
   }
}