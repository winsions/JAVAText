package cn.itcast.user.dao;

/**
 * Created by winsion on 2017/3/17.
 */
import java.io.*;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import cn.itcast.user.domain.User;

/**
 * ??????
 */
public interface UserDao {
    public User findByusername(String username);
    public void add(User user) throws SQLException;


}
