package concurrent.five.selfCache;

/**
 * @author bike
 * @create 2019-03-27 上午10:41
 * 复杂计算
 **/
public interface Computable<A, V> {
    V compute(A arg) throws InterruptedException;
}
