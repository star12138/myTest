package pattern.decorator.v2;

import pattern.decorator.v1.Battercake;

/**
 * 可以主动的获取煎饼+鸡蛋+香肠的价格
 *
 * @author bike
 * @create 2020-03-21 9:04 上午
 **/
public class BattercakeTest {

    public static void main(String[] args) {
        Battercake battercake = new Battercake();
        System.out.println(battercake.getMag() + " 价格：" + battercake.getPrice());

        battercake = new BattercakeWithEggs(2, battercake);
        System.out.println(battercake.getMag() + " 价格：" + battercake.getPrice());


        battercake = new BattercakeWithSausage(2, battercake);
        System.out.println(battercake.getMag() + " 价格：" + battercake.getPrice());

    }
}
