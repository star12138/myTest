package pattern.decorator.v3;

/**
 * @author bike
 * @create 2020-03-21 9:08 上午
 **/
public class BattercakeDecorator extends Battercake {

    private Battercake battercake;

    public BattercakeDecorator(Battercake battercake) {
        this.battercake = battercake;
    }

    @Override
    public String getMag() {
        return battercake.getMag();
    }

    @Override
    public int getPrice() {
        return battercake.getPrice();
    }
}
