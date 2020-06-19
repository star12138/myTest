package concurrent.semaphore;

import javax.smartcardio.Card;
import java.util.concurrent.Semaphore;

/**
 * @Auther: Administrator
 * @Date: 2020/5/4 14:42
 * @Description:
 */
public class SemaphoreDemo {

    static class Car extends Thread {
        private int num;
        private Semaphore semaphore;

        public Car(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("第" + num + " 抢占了一个车位");
                Thread.sleep(2000);
                System.out.println("第" + num + " 开走咯");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        for (int i=0; i < 10; i++) {
            new Car(i, semaphore).run();
        }
    }
}
