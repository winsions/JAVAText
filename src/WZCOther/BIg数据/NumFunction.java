package WZCOther.BIg数据;

import cn.itcast.user.DB.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by winsion on 2017/3/23.
 */

/*
数据处理
 */
public class NumFunction {




    public static void NumFunctionssss() throws SQLException {
        Connection connection = JDBC.getConnection();
        String sql ="INSERT INTO `use` VALUES (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        for (int i = 0;i < 1000000;i ++){

//        int i = 1;
            preparedStatement.setInt(1,i);
            preparedStatement.setString(2,"str_"+i);
            preparedStatement.setString(3,i%2==0?"男":"女");

            preparedStatement.addBatch();

        }
        long stat = System.currentTimeMillis();
        preparedStatement.executeBatch();
        long end = System.currentTimeMillis();
        System.out.println(end-stat);//6280
    }

    public static void main(String[] args) throws SQLException {
        NumFunction.NumFunctionssss();
    }
}
