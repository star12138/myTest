package pattern.strategy.pay.paypory;

import pattern.strategy.pay.MsgResult;

/**
 * @author bike
 * @create 2020-03-19 11:13 上午
 **/
public abstract class Payment {
    abstract String getName();

    abstract double query(String uid);

    public MsgResult pay(String uid, double amount) {
        if (query(uid) < amount) {
            return new MsgResult(500, getName() + " 付款失败，余额不足");
        }
        return new MsgResult(200, getName() + "付款成功；付款金额： " + amount);
    }

}
