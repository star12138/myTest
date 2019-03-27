package concurrent.five.selfCache;

import java.math.BigInteger;

/**
 * @author bike
 * @create 2019-03-27 上午10:42
 **/
public class ExpensiveFunction implements Computable<String, BigInteger>{
    public BigInteger compute(String arg) throws InterruptedException {
        // 经过长时间计算
        return new BigInteger(arg);
    }
}
