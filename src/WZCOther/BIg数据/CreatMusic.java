package WZCOther.BIg数据;

import cn.itcast.user.DB.JDBC;
import org.apache.commons.io.IOUtils;

import javax.servlet.jsp.jstl.sql.Result;
import javax.sql.rowset.serial.SerialBlob;
import java.io.*;
import java.sql.*;

/**
 * Created by winsion on 2017/3/23.
 */
public class CreatMusic {

    public static void saveMusic() throws SQLException {


        Connection connection = null;

        PreparedStatement preparedStatement = null;


        connection = JDBC.getConnection();
        String sql = "insert into table_bin values (?,?,?)";

        preparedStatement = connection.prepareStatement(sql);

        String ni = "成都";
        preparedStatement.setInt(1,6);
        preparedStatement.setString(2,"压缩包.mp3");
        byte[] bytes = null;
        try {
            bytes = IOUtils.toByteArray(new FileInputStream("/Users/winsion/Documents/源码/Java数据库/Java包.zip"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Blob blob = new SerialBlob(bytes);
        preparedStatement.setBlob(3,blob);
        preparedStatement.executeUpdate();


    }


    public static void downMusic() throws Exception{
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = JDBC.getConnection();
            String sql = "SELECT *FROM table_bin ";
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException e) {
           throw new RuntimeException(e);
        }

        ResultSet result =  preparedStatement.executeQuery();

        if (result.next()){
          Blob blob = result.getBlob("DATA");

          InputStream in = blob.getBinaryStream();
            OutputStream out = new FileOutputStream("/Users/winsion/Documents/源码/Java包.zip");
            IOUtils.copy(in,out);

        }

    }

    public static void main(String[] args) {
        try {
            CreatMusic.saveMusic();
            CreatMusic.downMusic();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
