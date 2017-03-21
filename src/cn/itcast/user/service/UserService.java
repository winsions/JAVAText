package cn.itcast.user.service;

import cn.itcast.user.dao.UserDao;
import cn.itcast.user.domain.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by winsion on 2017/3/17.
 */

/**
 * userҵ���߼���
 */
public class UserService {

    private UserDao userDao = new UserDao();

    //ע�Ṧ��
    public void register(User user) throws UserException{

        Map<String,String> errors = new HashMap<String, String>();

        //Ϊ��User
        if (user.getUserName() == "") throw new UserException("�û���Ϊ��");
        if (user.getPassWord() == "") throw new UserException("������Ϊ��");

        User _user = userDao.findByusername(user.getUserName());

        //�ж��Ƿ�Ϊ��
        if (_user!=null) throw new UserException("�û���" +user.getUserName()+"�ѱ�ע��");



        userDao.add(user);
    }

    //��¼����
    public User login(User user) throws UserException{
      User _user = userDao.findByusername(user.getUserName());
        //Ϊ��User
        if (user.getUserName() == "") throw new UserException("�û���Ϊ��");
        if (user.getPassWord() == "") throw new UserException("������Ϊ��");
        if (_user ==null) throw new UserException("���û�û��ע��");
        if (!_user.getPassWord().equals(user.getPassWord())) throw new UserException("�������");

        return _user;
    }
}