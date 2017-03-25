package cn.itcast.user.DB;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by winsion on 2017/3/24.
 */
public class JDdbfcp {

    //没有配置数据库的设置.默认配置文件要求你必须给出c3p0-config.xml！！！
    private static ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

    private static Connection con = null;

    public static Connection getConnec() throws SQLException {


        if (con != null) return con;

        return comboPooledDataSource.getConnection();

    }

    //连接池
    public static ComboPooledDataSource getDataDource(){

        return comboPooledDataSource;
    }


    //开启事物
    public static void  beginTransaction() throws SQLException{
        if (con!= null) throw new SQLException("已经开启事物");

        con = getConnec();
        con.setAutoCommit(false);

    }
    //提交事物
    public static void  commitTransaction() throws SQLException {

        if (con == null) throw new SQLException("没有开启事物");
        con.commit();
        con.close();
        con=null;

    }//回滚事物
    public static void  rollbackTransaction() throws SQLException {
        if (con == null) throw new SQLException("没有开启事物");
        con.rollback();
        con.close();
        con=null;

    }

    public static void main(String[] args) throws SQLException {

      Connection connection =  JDdbfcp.getConnec();
        if (connection!=null){
            System.out.println("zheg");
        }
    }
}
