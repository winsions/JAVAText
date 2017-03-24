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


    public static Connection getConnec() throws SQLException {



        return comboPooledDataSource.getConnection();

    }

    public static ComboPooledDataSource getDataDource(){

        return comboPooledDataSource;
    }

    public static void main(String[] args) throws SQLException {

      Connection connection =  JDdbfcp.getConnec();
        if (connection!=null){
            System.out.println("zheg");
        }
    }
}
