package concurrent.five.selfCache;

import java.util.Map;
import java.util.concurrent.*;

/**
 * @author bike
 * @create 2019-03-27 上午11:26
 *
 *  当缓存的是Future而不是值时， 将导致缓存污染(Cache Pollution) 问题
 *  如果某个计算被取消或者失败，那么在计算这个结果时将指明计算过程被取消或者失败。
 *  为了避免这种情况，如果Memoizer发现计算被取消，那么将把Future从缓存中移除。
 *
 *
 **/
public class Memoizer<A, V> implements Computable<A, V> {
    private final Map<A, Future<V>> cache = new ConcurrentHashMap<A, Future<V>>();
    private final Computable<A, V> c;

    public Memoizer(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(final A arg) throws InterruptedException {
        while (true) {
            Future<V> f = cache.get(arg);
            if (f == null) {
                Callable<V> eval = () -> c.compute(arg);
                FutureTask<V> ft = new FutureTask<>(eval);
                f = cache.putIfAbsent(arg, ft);
                if (f == null) {
                    f = ft;
                    ft.run();
                }
            }

            try {
                return f.get();
            } catch (CancellationException e) {
                cache.remove(arg, f);
            } catch (ExecutionException e) {
//            throw launderThrowable(e.getCause());
                System.out.println("");
            }
        }
    }
}
