package pattern.decorator.v1;

/**
 * 这个版本，只能单独的获取，加几个鸡蛋，或加几根香肠的 煎饼价格
 * 不能获取加香肠后再加鸡蛋的价格
 *
 * @author bike
 * @create 2020-03-21 8:54 上午
 **/
public class BatercakeTest {
    public static void main(String[] args) {
        Battercake battercake = new Battercake();
        System.out.println(battercake.getMag() + " 价格：" + battercake.getPrice());

        battercake = new BattercakeWithEgg(2);
        System.out.println(battercake.getMag() + " 价格：" + battercake.getPrice());

        battercake = new BattercakeWithSausage(2);
        System.out.println(battercake.getMag() + " 价格：" + battercake.getPrice());
    }
}
