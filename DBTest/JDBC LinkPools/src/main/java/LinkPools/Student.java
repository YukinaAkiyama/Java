package LinkPools;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Student {
    static Connection conn;
    static Statement sta;
    ResultSet rs = null;
    ResultSet rs2 = null;

    static {
        try {
            conn = JdbcUtils.getConnection();
            sta = conn.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Student() {

    }

    public void addStudents(int id, String name, String sex, int age, String classid, String subjects, int grades) throws SQLException {
        String sql = "insert into tb_emp values(" + id + ",'" + name+ "','"+ sex+"',"+ age+",'"+ classid+"','"+subjects+"',"+grades+")";
//        System.out.println(sql);
        sta.executeUpdate(sql);
    }

    protected void queryStudents() throws SQLException {
        rs =  sta.executeQuery("select * from tb_emp");
        System.out.println(rs);
        while (rs.next())
        {
            System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getString("sex")
                    + " " + rs.getString("age") + " " + rs.getString("classid")
                    + " " + rs.getString("subjects")+ " " + rs.getString("grades"));
        }

    }


    void getMaxAge() throws SQLException {
        System.out.println("最大年龄：");
        int max;
        String maxAge = null;
        String sql = "select max(age) from tb_emp";
        ResultSet rst = sta.executeQuery(sql);
        System.out.println(rst);
        try {
            maxAge = rst.getInt("id") + " " + rst.getString("name") + " " + rst.getString("sex")
                    + " " + rst.getString("age") + " " + rst.getString("classid")
                    + " " + rst.getString("subjects")+ " " + rst.getString("grades");
            System.out.println(maxAge);
        } catch (SQLException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
        assert maxAge != null;
        max = Integer.parseInt(maxAge);
        System.out.println(max);
    }
}
