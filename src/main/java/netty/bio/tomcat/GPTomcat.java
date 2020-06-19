package netty.bio.tomcat;

import netty.bio.tomcat.http.GPResponse;
import netty.bio.tomcat.http.GPServlet;
import netty.bio.tomcat.http.GPrequest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @Auther: Administrator
 * @Date: 2020/6/8 19:53
 * @Description:
 */
public class GPTomcat {
    /**
     * 1、配置好启动端口， 默认8080 ServerSocket IP：localhost
     * 2、配置web.xml 自己写的servlet继承httpServlet
     * servlet-name
     * servlet-class
     * url-parttern
     * 3、读取配置，url-parttern和servlet建立一个映射关系
     * Map servletMapping
     * 4、HTTP请求，发生的数据就是字符串，有规律的字符串
     * 5、从协议内容中拿到url，把相应的servlet用反射进行实例化
     * 6、调用实例化对象的service方法，执行具体的逻辑doGet/doPost方法
     * 7、request（inputstrean）/response（outputstream）
     */

    private int port = 8080;
    private ServerSocket server;
    private Map<String, GPServlet> servletMapping = new HashMap<>();

    private Properties webxml = new Properties();

    private void init() {
        try {
            String WEB_INF = this.getClass().getResource("/").getPath();
            FileInputStream fis = new FileInputStream(WEB_INF + "web");
            webxml.load(fis);
            for (Object k : webxml.keySet()) {
                String key = k.toString();
                if (key.endsWith(".url")) {
                    String servletName = key.replaceAll("\\.url$", "");
                    String url = webxml.getProperty(key);
                    String className = webxml.getProperty(servletName + ".className");
                    GPServlet obj = (GPServlet) Class.forName(className).newInstance();

                    servletMapping.put(url, obj);

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start() {
        // 1、加载配置文件
        init();
        try {
            server = new ServerSocket(this.port);
            System.out.println("GP Tomcat 已启动，监听的端口是： " + this.port);
            // 2、 等待用户请求，用一个死循环来等待用户请求
            while (true) {
                Socket client = server.accept();
                process(client);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void process(Socket client) throws IOException {
        InputStream is = client.getInputStream();
        OutputStream os = client.getOutputStream();

        GPrequest request = new GPrequest(is);
        GPResponse response = new GPResponse(os);

       String url = request.getUrl();
       if (servletMapping.containsKey(url)) {
           servletMapping.get(url).service(request, response);
       } else {
           response.write("404 Not Found");
       }
       os.flush();
       os.close();
       is.close();
       client.close();




    }

    public static void main(String[] args) throws ClassNotFoundException {
        new GPTomcat().start();
    }

}
