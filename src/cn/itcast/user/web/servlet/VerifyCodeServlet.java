package cn.itcast.user.web.servlet;

import cn.itcast.vcode.utils.VerifyCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by winsion on 2017/3/21.
 */
@WebServlet(name = "VerifyCodeServlet")
public class VerifyCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html,charset=utf-8");



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //get请求
        //生成验证码图片
        VerifyCode verifyCode = new VerifyCode();

        BufferedImage image = verifyCode.getImage();

        //保存在secction 中
        request.getSession().setAttribute("vercode_session",verifyCode.getText());


        verifyCode.output(image,response.getOutputStream());


    }
}
