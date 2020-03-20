package pattern.strategy.pay.paypory;

/**
 * @author bike
 * @create 2020-03-19 11:17 上午
 **/
public class WechatPay extends Payment {
    @Override
    String getName() {
        return "微信";
    }

    @Override
    double query(String uid) {
        return 500;
    }
}
