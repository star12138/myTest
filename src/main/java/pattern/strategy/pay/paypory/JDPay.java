package pattern.strategy.pay.paypory;

/**
 * @author bike
 * @create 2020-03-19 11:18 上午
 **/
public class JDPay extends Payment{
    @Override
    String getName() {
        return "京东白条";
    }

    @Override
    double query(String uid) {
        return 0;
    }
}
