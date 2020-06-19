package netty.bio.tomcat.http;

import java.io.InputStream;

/**
 * @Auther: Administrator
 * @Date: 2020/6/8 21:05
 * @Description:
 */
public class GPrequest {
    private String url;
    private String method;

    public GPrequest(InputStream inputStream) {
        try {
            String content = "";
            byte[] buff = new byte[1024];
            int len = 0;
            if ((len = inputStream.read(buff)) > 0) {
                content = new String(buff, 0, len);
            }
//            System.out.println(content);

            String line = content.split("\\n")[0];
            String[] arr = line.split("\\s");

            this.method = arr[0];
            this.url = arr[1];


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public String getUrl() {

        return url;
    }

    public String getMethod() {
        return method;
    }
}
