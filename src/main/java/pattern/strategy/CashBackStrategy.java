package pattern.strategy;

/**
 * @author bike
 * @create 2020-03-19 10:27 上午
 **/
public class CashBackStrategy implements PromotionStrategy {
    @Override
    public void execute() {
        System.out.println("返现活动");
    }
}
