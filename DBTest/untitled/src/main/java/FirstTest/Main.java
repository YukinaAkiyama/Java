package FirstTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws Exception {


        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://127.0.0.1:3306/study_1?serverTimezone=GMT%2B8&useSSL=FALSE";
        Connection conn = DriverManager.getConnection(url, "root", "139470");
        Statement stat = conn.createStatement();


        //创建表tb_emp
//        stat.executeUpdate("create table tb_emp(id int, name varchar(100),sex char(1),birth date,dept varchar(20))");

        //添加数据
        stat.executeUpdate("insert into tb_emp values(1, '张三','男','1997-11-2','开发部')");
        stat.executeUpdate("insert into tb_emp values(2, '大强','男','1996-10-2','财务部')");
        stat.executeUpdate("insert into tb_emp values(3, '小王','男','1998-11-15','营销部')");
        stat.executeUpdate("insert into tb_emp values(4, '小胖','女','1986-6-1','人事部')");
        stat.executeUpdate("insert into tb_emp values(5, '李毅','女','1999-7-6','开发部')");


        //查询数据
        ResultSet result = stat.executeQuery("select * from tb_emp");
        while (result.next())
        {
            System.out.println(result.getInt("id") + " " + result.getString("name") + " " + result.getString("sex")
                    + " " + result.getString("birth") + " " + result.getString("dept"));
        }


        //增加
        String sql1="insert into tb_emp values(6, '王五','女','1999-8-5','开发部')";   //SQL语句
        stat.executeUpdate(sql1);         //将sql语句上传至数据库执行
        System.out.println("增加后：");
        //查询数据
        ResultSet result2 = stat.executeQuery("select * from tb_emp");
        while (result2.next())
        {
            System.out.println(result2.getInt("id") + " " + result2.getString("name") + " " + result2.getString("sex")
                    + " " + result2.getString("birth") + " " + result2.getString("dept"));
        }
        //删除
        String sql2="delete from tb_emp where id='4'";   //SQL语句
        stat.executeUpdate(sql2);         //将sql语句上传至数据库执行
        System.out.println("删除后：");
        //查询数据
        ResultSet result3 = stat.executeQuery("select * from tb_emp");
        while (result3.next())
        {
            System.out.println(result3.getInt("id") + " " + result3.getString("name") + " " + result3.getString("sex")
                    + " " + result3.getString("birth") + " " + result3.getString("dept"));
        }
        //修改
        String sql3="update tb_emp set id='4' where name='王五' ";   //SQL语句
        stat.executeUpdate(sql3);         //将sql语句上传至数据库执行
        System.out.println("修改后：");
        //查询数据
        ResultSet result4 = stat.executeQuery("select * from tb_emp");
        while (result4.next())
        {
            System.out.println(result4.getInt("id") + " " + result4.getString("name") + " " + result4.getString("sex")
                    + " " + result4.getString("birth") + " " + result4.getString("dept"));
        }


        //关闭数据库
        result2.close();
        stat.close();
        conn.close();
    }

}
