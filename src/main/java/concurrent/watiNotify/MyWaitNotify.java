package concurrent.watiNotify;

/**
 * @author bike
 * @create 2019-08-29 10:50 AM
 **/
public class MyWaitNotify {
   private final MonitorObject monitorObject = new MonitorObject();

    public void doWait() {
        synchronized (monitorObject) {
            try {
                monitorObject.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void doNotify() {
        synchronized (monitorObject) {
            monitorObject.notify();
        }
    }
}
