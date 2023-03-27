package LinkPools;
import java.sql.SQLException;

public class TestInsert extends Student {
    public TestInsert() throws SQLException {
    }

    public static void main(String[] args) throws SQLException {

//      第一次使用时取消注释下行代码，进行数据表创建，之后使用将其注释
//        sta.executeUpdate("create table tb_emp(id int, name varchar(100),sex char(1),age int(10),clissid varchar(20),subjects varchar(255),grades int(20))");
//      创建父类Student对象
        Student f = new Student();
//      对象调用父类Student的addData函数
//      增加
        f.addStudents(20210001, "张三","男",20,"1班","Java程序设计基础",88);
        f.addStudents(20210002, "里斯","男",19,"1班","Java程序设计基础",98);
        f.addStudents(20210003, "王五","男",17,"2班","Java程序设计基础",95);
        f.addStudents(20210004, "李翠","女",18,"2班","Java程序设计基础",90);
        f.addStudents(20210005, "李翠","女",19,"3班","Java程序设计基础",93);
        f.addStudents(20210006, "王丽华","女",19,"3班","Java程序设计基础",86);
        f.addStudents(20210007, "陈红","女",20,"4班","Java程序设计基础",88);
        f.addStudents(20210008, "王小明","男",18,"4班","Java程序设计基础",98);
        System.out.println("增加如下数据：");
        f.queryStudents();


        f.getMaxAge();

    }
}