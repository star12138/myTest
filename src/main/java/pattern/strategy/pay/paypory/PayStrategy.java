package pattern.strategy.pay.paypory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bike
 * @create 2020-03-19 11:19 上午
 **/
public class PayStrategy {
    public static final String ALI_PAY = "aliPay";
    public static final String WECHAT_PAY = "WechatPay";
    public static final String JD_PAY = "JDPay";
    public static final String DEFAULT_PAY = ALI_PAY;

    private static Map<String, Payment> register = new HashMap<>();

    static {
        register.put(ALI_PAY, new AliPay());
        register.put(WECHAT_PAY, new WechatPay());
        register.put(JD_PAY, new JDPay());
    }

    public static Payment getPayment(String payKey) {
        if (register.containsKey(payKey)) {
            return register.get(payKey);
        }
        return register.get(DEFAULT_PAY);
    }

}
