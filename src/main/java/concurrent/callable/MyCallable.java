package concurrent.callable;

import java.util.concurrent.Callable;

/**
 * @author bike
 * @create 2019-12-23 9:57 AM
 **/
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        String value = "test";
        System.out.println("Ready to work");
        Thread.sleep(5000);
        System.out.println("task done");
        return value;
    }
}
