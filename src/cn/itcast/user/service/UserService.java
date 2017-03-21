package cn.itcast.user.service;

import cn.itcast.user.dao.UserDao;
import cn.itcast.user.domain.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by winsion on 2017/3/17.
 */

/**
 * user业务逻辑层
 */
public class UserService {

    private UserDao userDao = new UserDao();

    //注册功能
    public void register(User user) throws UserException{

        Map<String,String> errors = new HashMap<String, String>();

        //为空User
        if (user.getUserName() == "") throw new UserException("用户名为空");
        if (user.getPassWord() == "") throw new UserException("密码吗为空");

        User _user = userDao.findByusername(user.getUserName());

        //判断是否为空
        if (_user!=null) throw new UserException("用户名" +user.getUserName()+"已被注册");



        userDao.add(user);
    }

    //登录功能
    public User login(User user) throws UserException{
      User _user = userDao.findByusername(user.getUserName());
        //为空User
        if (user.getUserName() == "") throw new UserException("用户名为空");
        if (user.getPassWord() == "") throw new UserException("密码吗为空");
        if (_user ==null) throw new UserException("此用户没有注册");
        if (!_user.getPassWord().equals(user.getPassWord())) throw new UserException("密码错误");

        return _user;
    }
}