package pattern.strategy.pay;

import pattern.strategy.pay.paypory.PayStrategy;

/**
 * @author
 * @create 2020-03-19 11:24 上午
 **/
public class PayStrategyTest {
    public static void main(String[] args) {
        Order order = new Order("1", "2020031901", 600);
        MsgResult msgResult = order.pay(PayStrategy.JD_PAY);
        System.out.println(msgResult);

    }
}
