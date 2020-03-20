package concurrent.readWriteLock;

/**
 * 读写锁简单实现
 *
 * @author bike
 * @create 2019-08-27 11:31 AM
 **/
public class ReadWriteLock {
    private int readers = 0;
    private int writers = 0;
    private int writeRequests = 0;

    public synchronized void lockRead() throws InterruptedException {
        while (writers > 0 || writeRequests > 0) {
            wait();
        }
        readers++;
    }

    public synchronized void unlockRead() {
        readers--;
        notifyAll();
    }

    public synchronized void lockWtire() throws InterruptedException {
        writeRequests++;
        wait();
        writeRequests--;
        writers++;
    }

    public synchronized void unlockWrite() {
        writers--;
        notifyAll();
    }


}
