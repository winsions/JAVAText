package cn.itcast.user.web.servlet;

import cn.itcast.commons.CommonUtils;
import cn.itcast.user.domain.User;
import cn.itcast.user.service.UserException;
import cn.itcast.user.service.UserService;
import com.sun.deploy.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by winsion on 2017/3/17.
 */
@WebServlet(name = "RegistServlet")
public class RegistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        //�߶��������UTF-8����
        UserService userService = new UserService();

        //��װ��
        User form = CommonUtils.toBean(request.getParameterMap(), User.class);



        //�Ѵ����װ��map ��
        Map<String,String> errors = new HashMap<String, String>();

        String userName = form.getUserName();

        if (userName == null || userName.trim().isEmpty()){

            errors.put("userName","�û�������Ϊ��");

        } else if (userName.length()<3||userName.length()>15){
            errors.put("userName","�û������ȱ���զ3-15");
        }
        String passWord = form.getPassWord();

        if (passWord == null || passWord.trim().isEmpty()){

            errors.put("passWord","���벻��Ϊ��");

        } else if (passWord.length()<3||passWord.length()>15){
            errors.put("passWord","���볤�ȱ���զ3-15");

        }

        String _verifyCode = form.getVerifyCode();
        String verifyCode = (String) request.getSession().getAttribute("vercode_session");
        if (_verifyCode == null || passWord.trim().isEmpty()){

            errors.put("verifyCode","��֤�벻��Ϊ��");

        } else if (_verifyCode.length()!=4){
            errors.put("verifyCode","��֤�����Ϊ4");
        }else if (!verifyCode.equalsIgnoreCase(_verifyCode )){
            errors.put("verifyCode","��֤�����");
        }

        //�ж�map�Ƿ�Ϊ�˿�
        if (errors!= null&&errors.size()>0){

            request.setAttribute("errors",errors);
            //����������Ϣ  ������request����
            request.setAttribute("user",form);

            //ױ����regis.jsp
            request.getRequestDispatcher("/User/regist.jsp").forward(request,response);
            return;
        }

//        String verifyCode = (String) request.getSession().getAttribute("vercode_session");
//        System.out.println(verifyCode);
//        if (!verifyCode.equalsIgnoreCase(form.getVerifyCode())){
//            request.setAttribute("msg","��֤�����");
//            request.setAttribute("user",form);
//            request.getRequestDispatcher("/User/regist.jsp").forward(request,response);
//
//
//        }

        try {
            userService.register(form);
            response.getWriter().print("<h1>ע��ɹ���</h1><a href='" +
                    request.getContextPath() +
                    "/User/login.jsp" + "'>�������ȥ��¼</a>");
        } catch (UserException e){
         request.setAttribute("msg",e.getMessage());
         //����������Ϣ  ������request����
            request.setAttribute("user",form);

         //ױ����regis.jsp
         request.getRequestDispatcher("/User/regist.jsp").forward(request,response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
