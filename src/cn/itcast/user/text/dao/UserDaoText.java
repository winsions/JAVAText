package cn.itcast.user.text.dao;

import cn.itcast.user.dao.UserDao;
import cn.itcast.user.domain.User;

/**
 * Created by winsion on 2017/3/19.
 */
public class UserDaoText {

    public  void textFindByUsername(){

        UserDao userDao = new UserDao();
        User user = userDao.findByusername("���ӳ�");

        System.out.println(user);

    }

    public void TestAdd(){

        UserDao userDao = new UserDao();

        User user = new User();
        user.setUserName("���ӳ�");
        user.setPassWord("WZCX");
        userDao.add(user);
    }

    public static void main(String[] args) {


        UserDaoText userDaoText = new UserDaoText();
        userDaoText.textFindByUsername();
        userDaoText.TestAdd();
    }
}

