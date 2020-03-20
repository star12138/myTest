package concurrent.semaphore;

import java.util.concurrent.Semaphore;

/**
 * @author bike
 * @create 2019-09-02 10:08 AM
 **/
public class SendingThread extends Thread{
    Semaphore semaphore = null;

    public SendingThread(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
