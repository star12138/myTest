package concurrent.future;

import java.util.concurrent.*;

/**
 * @author bike
 * @create 2019-08-15 4:45 PM
 **/
public class FutureMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> future = new FutureTask<String>(new RealData("a"));

        ExecutorService executor = Executors.newFixedThreadPool(1);

        executor.submit(future);
//      变种
//        Future<String> future = executor.submit(new RealData("a"));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("数据= " + future.get());
    }
}
