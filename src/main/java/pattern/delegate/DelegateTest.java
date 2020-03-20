package pattern.delegate;

/**
 * 委派模式测试类
 * @author bike
 * @create 2020-03-19 9:22 上午
 **/
public class DelegateTest {
    public static void main(String[] args) {
        new Boss().command("算法", new Leader());
        new Boss().command("架构", new Leader());
    }
}
