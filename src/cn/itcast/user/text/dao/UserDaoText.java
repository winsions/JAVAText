package cn.itcast.user.text.dao;

import cn.itcast.user.dao.DaoFactory;
import cn.itcast.user.dao.UserDao;
import cn.itcast.user.domain.User;

import java.sql.SQLException;

/**
 * Created by winsion on 2017/3/19.
 */
public class UserDaoText {

    public  void textFindByUsername(){

        UserDao userDao = DaoFactory.getUserDao();
        User user = userDao.findByusername("王子臣");

        System.out.println(user);

    }

    public void TestAdd(){

        UserDao userDao = DaoFactory.getUserDao();

        User user = new User();
        user.setUserName("王子臣");
        user.setPassWord("WZCX");
        try {
            userDao.add(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {


        UserDaoText userDaoText = new UserDaoText();
        userDaoText.textFindByUsername();
        userDaoText.TestAdd();
    }
}

