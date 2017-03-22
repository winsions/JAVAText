package cn.itcast.user.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by winsion on 2017/3/22.
 */
public class DBHelp {

    private String dbUrl="jdbc:mysql://localhost:3306/sushe";
    private String dbUser="root";
    private String dbPassword="root";
    private String jdbcName="com.mysql.jdbc.Driver";

    public Connection getConnet() throws ClassNotFoundException,SQLException{

        Class.forName(jdbcName);

        //连接数据库
        Connection conn = DriverManager.getConnection(dbUrl,dbUser,dbPassword);
        if (!conn.isClosed()){
            System.out.println("qingodng chengogn");
        }


        return  conn;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        new DBHelp().getConnet();
    }

}
