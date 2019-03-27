package concurrent.five.selfCache;

import javax.annotation.concurrent.GuardedBy;
import java.util.HashMap;
import java.util.Map;

/**
 * @author bike
 * @create 2019-03-27 上午10:44
 * <p>
 * HashMap 不是线程安全的，因此要确保两个线程不会同时访问HashMap，对compute方法进行同步，确保了线程的安全性
 * 但会带来一个明显的可伸缩问题： 每次只有一个线程能够执行compute。如果另一个线程正在计算结果，那么其它调用compute
 * 的线程可能会被阻塞很长时间
 **/
public class Memoizer1<A, V> implements Computable<A, V> {
    @GuardedBy("this")
    private final Map<A, V> cache = new HashMap<A, V>();
    private final Computable<A, V> c;

    public Memoizer1(Computable<A, V> c) {
        this.c = c;
    }

    public synchronized V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}
