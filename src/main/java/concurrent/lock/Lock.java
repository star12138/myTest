package concurrent.lock;

/**
 * 这个锁，并不能实现公平性，效果和同步代码块类似
 * @author bike
 * @create 2019-08-29 11:36 AM
 **/
public class Lock {
    private boolean isLocked = false;
    private Thread lockingThread = null;
    public synchronized void lock() throws InterruptedException {
        while (isLocked){
            wait();
        }
        isLocked = false;
        lockingThread = Thread.currentThread();
    }

    public synchronized void unlock(){
        if (this.lockingThread != Thread.currentThread()){
            throw new IllegalMonitorStateException("Calling thread has not locked this lock");
        }
        isLocked = false;
        lockingThread = null;
        notify();
    }
}
