package pattern.strategy.pay;

import pattern.strategy.pay.paypory.PayStrategy;

/**
 * @author bike
 * @create 2020-03-19 11:10 上午
 **/
public class Order {
    private String uid;
    private String orderId;
    private double amount;

    public Order(String uid, String orderId, double amount) {
        this.uid = uid;
        this.orderId = orderId;
        this.amount = amount;
    }

    public MsgResult pay(String payKey){
        return PayStrategy.getPayment(payKey).pay(uid, amount);
    }
}
