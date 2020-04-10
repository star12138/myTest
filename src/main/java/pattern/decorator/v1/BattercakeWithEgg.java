package pattern.decorator.v1;

/**
 * @author bike
 * @create 2020-03-21 8:52 上午
 **/
public class BattercakeWithEgg extends Battercake {

    private int number;

    public BattercakeWithEgg(int number) {
        this.number = number;
    }

    @Override
    public String getMag() {
        return super.getMag() + " 加了" + number + "个鸡蛋";
    }

    @Override
    public int getPrice() {
        return super.getPrice() + number;
    }
}
