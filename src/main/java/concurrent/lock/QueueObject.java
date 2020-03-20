package concurrent.lock;

/**
 * @author bike
 * @create 2019-11-05 10:56 AM
 **/
public class QueueObject {
    private boolean isNotified = false;

    public synchronized void doWait() throws InterruptedException {
        while (!isNotified) {
            this.wait();
        }
        this.isNotified = false;
    }

    public synchronized void doNotify() {
        this.isNotified = true;
        this.notify();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj;
    }
}
