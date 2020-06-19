package concurrent.semaphore;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: Administrator
 * @Date: 2020/5/4 18:39
 * @Description:
 * 请结合 ReentrantLock condition实现一个简单的阻塞队列，阻塞队列提供两个方法，
 * 一个是put，一个是take
 * 1、当队列为空时，请求take会被阻塞，直到队列不为空
 * 2、当队列满了以后，put需要被阻塞，直到可以添加元素
 *
 */
public class BlockList<T> {
    private int size;
    private int DEFAULT_SIZE = 10;
    private ArrayList<T> list;
    private ReentrantLock lock;
    private Condition putCondition;
    private Condition takeCondition;

    public BlockList() {
        size = DEFAULT_SIZE;
        list = new ArrayList<>();
        lock = new ReentrantLock();
        putCondition = lock.newCondition();
        takeCondition = lock.newCondition();
    }
    public BlockList(int size) {
        this();
        this.size = size;
    }

    public boolean put(T t) throws InterruptedException {
        try {
            lock.lock();
            if (list.size() < size) {
                list.add(t);
                takeCondition.signalAll();

                return true;
            }
            System.out.println("存放数据阻塞，当前集合最多允许存放： " + list.size() + "个元素，请耐心等待");
            putCondition.await();
            return put(t);
        } finally {
            lock.unlock();
        }
    }

    public T take() throws InterruptedException {
        try {
            lock.lock();
            if (list.size() > 0) {
                putCondition.signalAll();
                T t = list.get(0);
                list.remove(t);
                return t;
            }
            System.out.println("读取数据阻塞，当前集合有： " + list.size() + " 个元素，无数据可读");
            takeCondition.await();
            return take();
        } finally {
            lock.unlock();
        }

    }
}
