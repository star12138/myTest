package netty.bio.tomcat.http;

import javax.servlet.http.HttpServlet;

/**
 * @Auther: Administrator
 * @Date: 2020/6/8 20:58
 * @Description:
 */
public abstract class GPServlet {
    public void service(GPrequest request, GPResponse response) {
        if ("GET".equalsIgnoreCase(request.getMethod())) {
            doGet(request, response);
        } else {
            doPost(request, response);
        }
    }

    protected abstract void doPost(GPrequest request, GPResponse response);

    protected abstract void doGet(GPrequest request, GPResponse response);
}
