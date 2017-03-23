package cn.itcast.user.DB;

import cn.itcast.jdbc.JdbcUtils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Created by winsion on 2017/3/22.
 */
public class DBHelp {


    private static Connection con = null;
    Statement stmt = null;

    static {
        JDBC jdbc = new JDBC();
        try {
            con = jdbc.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
       DBHelp dbHelp = new DBHelp();
       dbHelp.change("");
//        dbHelp.search("");
    }

    //增删改查
    public void change(String sql) throws SQLException {

        if (sql.length() ==0) sql = "INSERT INTO `user` (`id`,`name`) VALUES ('51','我饿啊啊啊啊啊hhahah')";
        Statement statement = con.createStatement();
          //String sql = "INSERT INTO `user` (`id`,`name`) VALUES ('51','我饿啊啊啊啊啊hhahah')";
        String sqljahah = "我饿";
        int r= statement.executeUpdate(sql);
        System.out.println(r);
        con.close();
    }


    public void search(String sql) throws SQLException{

        if (sql.length()==0) sql = "SELECT *FROM USER WHERE id =?";

        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1,"16");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int empo = resultSet.getInt(1);
            String name = resultSet.getString("name");
            System.out.println(empo+","+name);
        }

        con.close();
    }
}
