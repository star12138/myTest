package pattern.singleton.Lazy;

/**
 * @author bike
 * @create 2020-03-17 9:26 上午
 **/
public class LazyTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(new ExectorThread());
        Thread t2 = new Thread(new ExectorThread());

        t1.start();
        t2.start();
        System.out.println("end");
    }
}
