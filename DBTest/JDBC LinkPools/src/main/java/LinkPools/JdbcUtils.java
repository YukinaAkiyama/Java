package LinkPools;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtils {
    private static String url = null;
    private static String user = null;
    private static String password = null;
    static{

        try{
            // 读取db.properties
            InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties");
            Properties properties = new Properties();
            properties.load(in);
            String driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");

            // 加载驱动
            Class.forName(driver);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    // 创建连接
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url,user,password);
    }
    // 释放连接
    public static void releaseConnection(Connection conn, Statement sta, ResultSet rs){
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (sta != null){
            try {
                sta.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
