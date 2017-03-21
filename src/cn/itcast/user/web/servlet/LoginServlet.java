package cn.itcast.user.web.servlet;

import cn.itcast.commons.CommonUtils;
import cn.itcast.user.domain.User;
import cn.itcast.user.service.UserException;
import cn.itcast.user.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by winsion on 2017/3/17.
 */

/**
 * userservlet��
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html,charset=utf-8");

        response.setCharacterEncoding("utf-8");
        UserService userService = new UserService();

        //��װ��¼��
        User form = CommonUtils.toBean(request.getParameterMap(),User.class);
        try {
           User user = userService.login(form);
            //��¼�ɹ�

            request.getSession().setAttribute("sessionUser",user);

            response.sendRedirect(request.getContextPath()+"/User/welcome.jsp");
//            response.getWriter().print("<h1>��¼�ɹ���</h1><a href='" +
//                    request.getContextPath() +
//                    "/User/regist.jsp" + "'>�������ȥע��</a>");

        } catch (UserException e){
            //�����͵� Loginҳ��
            request.setAttribute("msg",e.getMessage());
            request.setAttribute("user",form);
            request.getRequestDispatcher("/User/login.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
