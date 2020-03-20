package concurrent.watiNotify;

/**
 * 信号量，自旋锁
 * @author bike
 * @create 2019-08-29 10:58 AM
 **/
public class MyWatiNotify3 {
    private final MonitorObject monitorObject = new MonitorObject();
    private boolean wasSignalled = false;

    public void doWait(){
        synchronized (monitorObject){
            while (!wasSignalled){
                try {
                    monitorObject.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            wasSignalled = false;
        }
    }

    public void doNotify(){
        synchronized (monitorObject){
            wasSignalled = true;
            monitorObject.notify();
        }
    }
}
