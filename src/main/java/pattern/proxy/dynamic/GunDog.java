package pattern.proxy.dynamic;

/**
 * 目标类
 * @author bike
 * @create 2020-03-18 9:54 上午
 **/
public class GunDog implements IDog {
    @Override
    public void run() {
        System.out.println("猎狗在跑");
    }

    @Override
    public void eat() {
        System.out.println("猎狗吃肉");
    }
}
