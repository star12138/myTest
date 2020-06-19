package netty.bio.tomcat.servlet;

import netty.bio.tomcat.http.GPResponse;
import netty.bio.tomcat.http.GPServlet;
import netty.bio.tomcat.http.GPrequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: Administrator
 * @Date: 2020/6/8 21:06
 * @Description:
 */
public class FirstServlet extends GPServlet {
    protected void doGet(GPrequest req, GPResponse resp){
        this.doPost(req, resp);
    }

    protected void doPost(GPrequest req, GPResponse resp) {
        resp.write("This is First Servlet");
    }
}
