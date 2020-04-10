package pattern.decorator.v3;

/**
 * @author
 * @create 2020-03-21 9:14 上午
 **/
public class BattercakeTest {
    public static void main(String[] args) {
        BattercakeDecorator battercake = new BattercakeDecorator(new BaseBattercake());
        System.out.println(battercake.getMag() + " 价格：" + battercake.getPrice());

        battercake = new EggDecorator(battercake);
        System.out.println(battercake.getMag() + " 价格：" + battercake.getPrice());

        battercake = new EggDecorator(battercake);
        System.out.println(battercake.getMag() + " 价格：" + battercake.getPrice());

        battercake = new SausageDecorator(battercake);
        System.out.println(battercake.getMag() + " 价格：" + battercake.getPrice());
    }
}
