package concurrent.five.selfCache;

import java.util.Map;
import java.util.concurrent.*;

/**
 * @author bike
 * @create 2019-03-27 上午11:06
 * 优点
 * 非常好的并发性（来源于 ConcurrentHashMap）
 * 缺陷
 * 仍然存在两个线程计算出相同值的漏洞，这个漏洞的发生概率要远小于Memoizer2
 * 但是由于compute方法中的if代码块仍然是飞原子的
 **/
public class Memoizer3<A, V> implements Computable<A, V> {
    private final Map<A, Future<V>> cache = new ConcurrentHashMap<A, Future<V>>();
    private final Computable<A, V> c;

    public Memoizer3(Computable<A, V> c) {
        this.c = c;
    }

    public V compute(final A arg) throws InterruptedException {
        Future<V> f = cache.get(arg);
        if (f == null){
            Callable<V> eval = new Callable<V>() {
                public V call() throws Exception {
                    return c.compute(arg);
                }
            };
            FutureTask<V> ft = new FutureTask<V>(eval);
            f = ft;
            cache.put(arg, ft);
            ft.run(); // 在这里将调用c.compute
        }

        try {
            return f.get();
        } catch (ExecutionException e){
//            throw launderThrowable(e.getCause());
            System.out.println("");
        }

        return null;
    }
}
