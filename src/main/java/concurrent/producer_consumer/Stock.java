package concurrent.producer_consumer;

import lombok.Data;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author bike
 * @create 2019-08-22 5:00 PM
 * <p>
 * 存货
 **/
@Data
public class Stock {
    private String name;
    private AtomicInteger number;
    private final int MAX_NUMBER;
    private final int MIN_NUMBER;
    private ReentrantLock lock = new ReentrantLock();
    private LinkedBlockingQueue<Integer> numberList = new LinkedBlockingQueue<>(10);

    public Stock(String name, AtomicInteger number, int MAX_NUMBER, int MIN_NUMBER) {
        this.name = name;
        this.number = number;
        this.MAX_NUMBER = MAX_NUMBER;
        this.MIN_NUMBER = MIN_NUMBER;
    }

    public synchronized void produce() {
        for (int i = 0; i < 100; i++) {
            if (i == 99) {
                System.out.println(i);
            }
            if (this.getNumber().get() >= this.getMAX_NUMBER()) {
                System.out.println(" 产品已满，请稍后生产");
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            this.getNumber().getAndIncrement();
            System.out.println("生产者生产第 " + this.getNumber().get() + "个产品");
            notifyAll();
            if (this.getNumber().get() >= this.getMIN_NUMBER()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized void consume() {
        for (int i = 0; i < 100; i++) {
            if (this.getNumber().get() < this.getMIN_NUMBER()) {
                System.out.println("当前库存 " + this.getNumber().get() + "个,请生产产品");
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("消费者消费第 " + this.getNumber().get() + "个产品");
            this.getNumber().getAndDecrement();
            notifyAll();
        }
    }

    public void produce2() {
        for (int i = 0; i < 100; i++) {
            try {
                this.getNumber().getAndIncrement();
                this.numberList.put(this.getNumber().get());
                System.out.println("生产第 " + this.numberList.peek() + "个产品");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void consume2(){
        for (int i = 0; i < 100; i++) {
            try {
                lock.lock();
                System.out.println("消费第 " + this.numberList.take() + "个产品");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Stock s = new Stock("苹果", new AtomicInteger(0), 100, 10);
        Producer p = new Producer();
        Consumer c = new Consumer();
        Thread t1 = new Thread(p);
        Thread t2 = new Thread(c);
        p.setS(s);
        c.setS(s);
        t1.start();
        t2.start();

    }
}
