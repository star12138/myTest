package concurrent.eight.puzzle;

import java.util.concurrent.CountDownLatch;

/**
 * @Auther: Administrator
 * @Date: 2020/4/26 10:55
 * @Description:
 */
public class ValueLatch<T> {
    private T value = null;
    private final CountDownLatch done = new CountDownLatch(1);

    public boolean isSet(){
        return (done.getCount() == 0);
    }

    public synchronized void setValue(T newValue){
        if (!isSet()){
            value = newValue;
            done.countDown();
        }
    }

    public T getValue() throws InterruptedException {
        done.await();
        synchronized (this) {
            return value;
        }
    }
}
