package pattern.strategy.pay.paypory;

/**
 * @author
 * @create 2020-03-19 11:17 上午
 **/
public class AliPay extends Payment {
    @Override
    String getName() {
        return "支付宝";
    }

    @Override
    double query(String uid) {
        return 1000;
    }
}
