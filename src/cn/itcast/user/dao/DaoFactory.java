package cn.itcast.user.dao;

import cn.itcast.user.domain.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by winsion on 2017/3/23.
 */
public class DaoFactory {

    private static Properties properties = null;
    static {
        //加载配置文件
        InputStream inputStream = DaoFactory.class.getClassLoader().getResourceAsStream("Dao.properties");
         properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static UserDao getUserDao() {

        String daoclassname = properties.getProperty("cn.itcast.user.dao.UserDao");

        try {
            Class clazz = Class.forName(daoclassname);
            return (UserDao)clazz.newInstance();
        } catch(Exception e) {
            throw new RuntimeException(e);
        }

    }

}
