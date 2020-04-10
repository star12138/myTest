package pattern.adapter;

/**
 * @author bike
 * @create 2020-03-20 11:09 上午
 **/
public class ResultMsg {
    private int code;
    private String msg;
    private Object data;

    public ResultMsg(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
