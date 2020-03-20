package pattern.singleton.Lazy;

/**
 * @author bike
 * @create 2020-03-17 9:20 上午
 **/
public class ExectorThread implements Runnable {

    @Override
    public void run() {
        LazySimpleSingleton simpleSingleton = LazySimpleSingleton.getInstance();
        System.out.println(Thread.currentThread().getName() +  ":" + simpleSingleton);
    }
}
