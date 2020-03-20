package pattern.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bike
 * @create 2020-03-19 10:31 上午
 **/
public class PromotionStrategyFactory {

    private static Map<String, PromotionStrategy> register = new HashMap<>();

    private static final PromotionStrategy PROMOTION_EMPTY = new EmptyStrategy();

    static {
        register.put(PromotionKey.CASH_BACK, new CashBackStrategy());
        register.put(PromotionKey.COUPON, new CouponStrategy());
        register.put(PromotionKey.GROUP_BY, new GroupByStrategy());
    }

    private PromotionStrategyFactory() {

    }

    public static PromotionStrategy getPromotionStrategy(String promotion) {
        PromotionStrategy promotionStrategy = register.get(promotion);
        return promotionStrategy == null ? PROMOTION_EMPTY : promotionStrategy;
    }

    public interface PromotionKey {
        String CASH_BACK = "cashBack";
        String COUPON = "coupon";
        String GROUP_BY = "groupBy";
    }

}
