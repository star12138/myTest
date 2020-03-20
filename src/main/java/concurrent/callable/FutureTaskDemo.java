package concurrent.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author bike
 * @create 2019-12-23 10:01 AM
 **/
public class FutureTaskDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> task = new FutureTask<>(new MyCallable());
        new Thread(task).start();
        if (!task.isDone()){
            System.out.println("task has not finished, please wait!");
        }
        System.out.println("task return: " + task.get());
    }
}
