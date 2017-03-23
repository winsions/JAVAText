package cn.itcast.user.dao;

import cn.itcast.user.DB.DBHelp;
import cn.itcast.user.DB.JDBC;
import cn.itcast.user.domain.User;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * Created by winsion on 2017/3/23.
 */
public class UserDaoImpl  implements UserDao{

    private  String path = "/Users/winsion/Documents/源码/Java数据库/users.xml";
    //    private  String path = "/Users/winsion/Desktop/users.xml";
    public User findByusername(String username){

        DBHelp dbHelp = new DBHelp();



       //读取本地文件
        //??????????
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
         * 1. ???Document
         * 2. ???Document???root????<users>
         * 3. ???????user???????Element????
         * 4. ??element????root?????
         * 5. ????Document
         *
         */

        //读取本地xml数据
        SAXReader reader = new SAXReader();
        try{
            Document document = reader.read(path);
            //????????
            Element root = document.getRootElement();
            Element elsUser = root.addElement("user");
            elsUser.addAttribute("username",user.getUserName());
            elsUser.addAttribute("password",user.getPassWord());
            // ??????????????
            OutputFormat format = new OutputFormat("\t", true);//???????\t???????????????
            format.setTrimText(true);//?????????????????
            //????xmlWriter

            XMLWriter writer;
            try {
                writer = new XMLWriter(
                        new OutputStreamWriter(
                                new FileOutputStream(path), "UTF-8"),format);
                writer.write(document);//????document????
                writer.close();
            } catch (Exception e){
                throw new RuntimeException(e);
            }



        } catch (DocumentException e){
            throw new RuntimeException(e);
        }
    };
}
