package cn.itcast.user.DB;

import cn.itcast.jdbc.JdbcUtils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by winsion on 2017/3/22.
 */
public class DBHelp {

    private static Properties properties = null;

    //ִֻ��һ��
    static {
        InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("DbConfig.properties");
        properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //����������
        try {
            Class.forName(properties.getProperty("driverClassName"));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public Connection getConnet() throws ClassNotFoundException, SQLException, IOException {

        //�������ݿ�
        Connection conn = DriverManager.getConnection(properties.getProperty("dbUrl"),
                properties.getProperty("dbUser"),
                properties.getProperty("dbPassword"));
        if (!conn.isClosed()){
            System.out.println("qingodng chengogn");
        }


        return  conn;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        new DBHelp().getConnet();
    }

}
