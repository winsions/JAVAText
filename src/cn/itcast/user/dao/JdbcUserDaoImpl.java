package cn.itcast.user.dao;

import cn.itcast.user.DB.JDBC;
import cn.itcast.user.domain.User;
import com.mysql.jdbc.JDBC4Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by winsion on 2017/3/23.
 */
public class JdbcUserDaoImpl implements UserDao {

    @Override
    public User findByusername(String username) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;
        try {
            connection = JDBC.getConnection();
            String sql = "SELECT * FROM users WHERE userName=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            resultSet = preparedStatement.executeQuery();
            if (resultSet == null) {
                return null;
            }
            if (resultSet.next()){
                //转换user
                User user = new User();

                user.setUserName(resultSet.getString("userName"));
                user.setPassWord(resultSet.getString("passWord"));
                user.setVerifyCode(resultSet.getString("verifyCode"));
                return user;
            }else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

            JdbcUserDaoImpl.closeConnect(connection,preparedStatement);
        }

    }

    @Override
    public void add(User user) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = JDBC.getConnection();
            String sql = "INSERT INTO users VALUES (?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getUserName());
            preparedStatement.setString(2,user.getPassWord());
            preparedStatement.setString(3,user.getVerifyCode());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUserDaoImpl.closeConnect(connection,preparedStatement);

        }
    }

    public static void closeConnect(Connection connection,PreparedStatement preparedStatement){
        try {
            if (connection != null)
                connection.close();
            if (preparedStatement != null)
                preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
