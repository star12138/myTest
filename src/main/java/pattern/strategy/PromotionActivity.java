package pattern.strategy;

/**
 * @author bike
 * @create 2020-03-19 10:42 上午
 **/
public class PromotionActivity {
    private PromotionStrategy promotionStrategy;

    public PromotionActivity(PromotionStrategy promotionStrategy) {
        this.promotionStrategy = promotionStrategy;
    }

    public void execute() {
        promotionStrategy.execute();
    }
}
