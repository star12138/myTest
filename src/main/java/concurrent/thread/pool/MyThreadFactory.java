package concurrent.thread.pool;

import java.util.concurrent.ThreadFactory;

/**
 *
 * @author bike
 * @create 2019-08-13 5:15 PM
 **/
public class MyThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        return null;
    }
}
