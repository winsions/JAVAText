package SeveletFunction.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by winsion on 2017/3/24.
 */
@WebServlet(name = "BasesServlet")
public  class BasesServlet extends BaseSevelet {



    protected String adduser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("adduser");
        return "f:index.jsp";
    }

    protected String  editorUsr(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("editorUsr");

        return "r:index.jsp";

    }


}
