package pattern.strategy;

/**
 * @author bike
 * @create 2020-03-19 10:43 上午
 **/
public class PromotionActivityTest {
    public static void main(String[] args) {
        String promotionKey = "cashBack";
        PromotionActivity activity = new PromotionActivity(PromotionStrategyFactory.getPromotionStrategy(promotionKey));
        activity.execute();
    }
}
