package netty.bio.tomcat.http;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @Auther: Administrator
 * @Date: 2020/6/8 21:05
 * @Description:
 */
public class GPResponse {
    private OutputStream outputStream;

    public GPResponse(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void write(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append("HTTP/1.1 200 OK\n")
                .append("Content-Type: text/html \n")
                .append("\r\n");
        sb.append(s);
        try {
            outputStream.write(sb.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
