package pattern.strategy.pay;

/**
 * @author bike
 * @create 2020-03-19 11:11 上午
 **/
public class MsgResult {
    private int code;
    private String data;

    public MsgResult(int code, String data) {
        this.code = code;
        this.data = data;
    }

    @Override
    public String toString() {
        return data;
    }
}
