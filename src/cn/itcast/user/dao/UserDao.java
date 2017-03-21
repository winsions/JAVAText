package cn.itcast.user.dao;

/**
 * Created by winsion on 2017/3/17.
 */
import java.io.*;
import java.util.concurrent.ExecutionException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import cn.itcast.user.domain.User;

/**
 * 数据类
 */
public class UserDao {


    private  String path = "/Users/winsion/Documents/源码/Java数据库/users.xml";
//    private  String path = "/Users/winsion/Desktop/users.xml";
    public User findByusername(String username){

        /**
         * 1. 得到Document
         * 2. xpath查询！
         *   3. 校验查询结果是否为null，如果为null，返回null
         *   4. 如果不为null，需要把Element封装到User对象中。
         */
        //创建解析器
        SAXReader reader = new SAXReader();

        try{
            Document document = reader.read(path);
            Element ele = (Element)document.selectSingleNode("//user[@username='" + username + "']");

            if (ele == null) return null;

            User user = new User();

            String userN = ele.attributeValue("username");
            String passward = ele.attributeValue("password");
            user.setUserName(userN);
            user.setPassWord(passward);
            return user;
        } catch (DocumentException ex){
            throw new RuntimeException(ex);
        }
    };

    public void add(User user){

        /**
         * 1. 得到Document
         * 2. 通过Document得到root元素！<users>
         * 3. 使用参数user，转发成Element对象
         * 4. 把element添加到root元素中
         * 5. 保存Document
         *
         */

        //创建解析器
        SAXReader reader = new SAXReader();
        try{
            Document document = reader.read(path);
            //得到根元素
            Element root = document.getRootElement();
            Element elsUser = root.addElement("user");
            elsUser.addAttribute("username",user.getUserName());
            elsUser.addAttribute("password",user.getPassWord());
            // 创建输出格式化器
            OutputFormat format = new OutputFormat("\t", true);//缩进使用\t，是否换行，使用是！
            format.setTrimText(true);//清空原有的换行和缩进
            //创建xmlWriter

           XMLWriter writer;
                try {
                    writer = new XMLWriter(
                            new OutputStreamWriter(
                                    new FileOutputStream(path), "UTF-8"),format);
                    writer.write(document);//保存document对象
                    writer.close();
            } catch (Exception e){
                throw new RuntimeException(e);
            }



        } catch (DocumentException e){
            throw new RuntimeException(e);
        }
    };
}
