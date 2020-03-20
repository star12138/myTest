package pattern.strategy;

/**
 * @author
 * @create 2020-03-19 10:29 上午
 **/
public class CouponStrategy implements PromotionStrategy {
    @Override
    public void execute() {
        System.out.println("优惠卷");
    }
}
