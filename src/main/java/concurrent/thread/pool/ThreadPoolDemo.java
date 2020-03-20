package concurrent.thread.pool;

import java.util.concurrent.*;

/**
 * 线程池
 * @author bike
 * @create 2019-08-13 4:31 PM
 **/
public class ThreadPoolDemo {
    public static class MyTask implements Runnable{

        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + ":Thread ID:" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyTask task = new MyTask();
        ThreadPoolExecutor pe = new ThreadPoolExecutor(5,5,1000L
                ,TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
//                Executors.newFixedThreadPool(5, poolExecutor);
        for (int i = 0; i < 10; i++){
            pe.submit(task);
        }
    }
}
