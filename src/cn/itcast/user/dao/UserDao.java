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
 * ������
 */
public class UserDao {


    private  String path = "/Users/winsion/Documents/Դ��/Java���ݿ�/users.xml";
//    private  String path = "/Users/winsion/Desktop/users.xml";
    public User findByusername(String username){

        /**
         * 1. �õ�Document
         * 2. xpath��ѯ��
         *   3. У���ѯ����Ƿ�Ϊnull�����Ϊnull������null
         *   4. �����Ϊnull����Ҫ��Element��װ��User�����С�
         */
        //����������
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
         * 1. �õ�Document
         * 2. ͨ��Document�õ�rootԪ�أ�<users>
         * 3. ʹ�ò���user��ת����Element����
         * 4. ��element��ӵ�rootԪ����
         * 5. ����Document
         *
         */

        //����������
        SAXReader reader = new SAXReader();
        try{
            Document document = reader.read(path);
            //�õ���Ԫ��
            Element root = document.getRootElement();
            Element elsUser = root.addElement("user");
            elsUser.addAttribute("username",user.getUserName());
            elsUser.addAttribute("password",user.getPassWord());
            // ���������ʽ����
            OutputFormat format = new OutputFormat("\t", true);//����ʹ��\t���Ƿ��У�ʹ���ǣ�
            format.setTrimText(true);//���ԭ�еĻ��к�����
            //����xmlWriter

           XMLWriter writer;
                try {
                    writer = new XMLWriter(
                            new OutputStreamWriter(
                                    new FileOutputStream(path), "UTF-8"),format);
                    writer.write(document);//����document����
                    writer.close();
            } catch (Exception e){
                throw new RuntimeException(e);
            }



        } catch (DocumentException e){
            throw new RuntimeException(e);
        }
    };
}
