package concurrent.watiNotify;

/**
 * 添加信号量,这种情况信号量会丢失
 * @author bike
 * @create 2019-08-29 10:54 AM
 **/
public class MyWatiNotify2 {
    private final MonitorObject monitorObject = new MonitorObject();
    private boolean wasSignalled = false;

    public void doWait(){
        synchronized (monitorObject){
            if(!wasSignalled){
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
