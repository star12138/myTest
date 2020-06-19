package pattern.decorator.v3;

/**
 * @author
 * @create 2020-03-21 9:10 上午
 **/
public class EggDecorator extends BattercakeDecorator {

    public EggDecorator(Battercake battercake) {
        super(battercake);
    }

    @Override
    public String getMag() {
        return super.getMag() + " 加一个鸡蛋";
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 1;
    }
}
