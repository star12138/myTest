package pattern.decorator.v1;

/**
 * @author
 * @create 2020-03-21 8:53 上午
 **/
public class BattercakeWithSausage extends Battercake {
    private int number;

    public BattercakeWithSausage(int number) {
        this.number = number;
    }

    @Override
    public String getMag() {
        return super.getMag() + " 加了" + number + "根香肠";
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 2 * number;
    }
}
