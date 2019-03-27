package concurrent.five.selfCache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author bike
 * @create 2019-03-27 上午10:56
 *
 * CocurrentHashMap是线程安全的，避免的Memoizer1同步带来的串行性；
 * 有更好的并发行为
 *
 * 不足：
 * 当两个线程同时调用compute时存在一个漏洞，可能会导致计算得到相同的值。
 * 在使用 memoization 的情况下，这只会带来低效，因为缓存的作用是避免相同的数据被计算多次。
 * 但对于更通用的缓存机制来说，这种情况将会更为糟糕。
 * 对于只提供单次初始化的对象缓存来说，这个漏洞会带来安全风险
 *
 **/
public class Memoizer2 <A, V> implements Computable<A, V> {
    private final Map<A, V> cache = new ConcurrentHashMap<A, V>();
    private final Computable<A, V> c;

    public Memoizer2(Computable<A, V> c) {
        this.c = c;
    }

    public V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null){
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}
