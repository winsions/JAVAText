package cn.itcast.user.service;

import cn.itcast.user.dao.DaoFactory;
import cn.itcast.user.dao.UserDao;
import cn.itcast.user.domain.User;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by winsion on 2017/3/17.
 */

/**
 *user业务逻辑层
 */
public class UserService {

    private UserDao userDao = DaoFactory.getUserDao();

    //注册功能
    public void register(User user) throws UserException{



        User _user = userDao.findByusername(user.getUserName());

        //判断是否为空
        if (_user!=null) throw new UserException("此用户" +user.getUserName()+"没有注册");

        try {
            userDao.add(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //登录功能
    public User login(User user) throws UserException{
      User _user = userDao.findByusername(user.getUserName());
        //用户名为空
        if (user.getUserName() == "") throw new UserException("用户名为空");
        if (user.getPassWord() == "") throw new UserException("密码吗为空");
        if (_user ==null) throw new UserException("此用户没有注册");
        if (!_user.getPassWord().equals(user.getPassWord())) throw new UserException("密码错误");

        return _user;
    }
}