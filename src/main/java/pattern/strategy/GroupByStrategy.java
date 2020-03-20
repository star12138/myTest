package pattern.strategy;

/**
 * @author bike
 * @create 2020-03-19 10:30 上午
 **/
public class GroupByStrategy implements PromotionStrategy {
    @Override
    public void execute() {
        System.out.println("团购");
    }
}
