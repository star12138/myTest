package pattern.strategy;

/**
 * @author bike
 * @create 2020-03-19 10:28 上午
 **/
public class EmptyStrategy implements PromotionStrategy{
    @Override
    public void execute() {
        System.out.println("无活动");
    }
}
