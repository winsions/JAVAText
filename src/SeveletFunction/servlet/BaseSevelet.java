package SeveletFunction.servlet;

import com.mysql.jdbc.Buffer;
import com.sun.tools.corba.se.idl.StringGen;
import javafx.scene.shape.Path;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Created by winsion on 2017/3/25.
 */

/*
对selevet的封装
 */
public abstract class BaseSevelet extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        super.service(req, res);
        String methName = req.getParameter("method");

        if (methName == null|| methName.length() == 0){
            throw new RuntimeException("没有传入method");
        }
        Class c = this.getClass();
        Method method = null;
        String result =null;
        try {
            method = c.getDeclaredMethod(methName,HttpServletRequest.class,HttpServletResponse.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("你调用的方法不存在");
        }

        try {
            result =(String) method.invoke(this,req,res);

           if (result == null || result.trim().isEmpty()){

               return;
           }
           if (result.contains(":")){

               int index = result.indexOf(":");
             String start = result.substring(0,index);
             String path =  result.substring(index+1);
               if (start.equalsIgnoreCase("r")){
                   res.sendRedirect(req.getContextPath()+path);
               }else if (start.equalsIgnoreCase("f")){//转发
                   req.getRequestDispatcher(path).forward(req,res);
               }else {

               }

           } else {//moren 转发
               req.getRequestDispatcher(result).forward(req,res);
           }


        } catch (Exception e) {
            throw new RuntimeException("调用方法失败");
        }
    }
}
