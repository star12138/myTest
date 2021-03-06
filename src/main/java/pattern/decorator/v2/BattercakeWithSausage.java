package pattern.decorator.v2;

import pattern.decorator.v1.Battercake;

/**
 * @author bike
 * @create 2020-03-21 9:03 上午
 **/
public class BattercakeWithSausage extends Battercake {
    private int number;

    private Battercake battercake;

    public BattercakeWithSausage(int number, Battercake battercake) {
        this.number = number;
        this.battercake = battercake;
    }

    @Override
    public String getMag() {
        return battercake.getMag() + " 加" + number + "跟火腿";
    }

    @Override
    public int getPrice() {
        return battercake.getPrice() + number * 2;
    }
}
