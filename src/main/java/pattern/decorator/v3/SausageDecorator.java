package pattern.decorator.v3;

/**
 * @author
 * @create 2020-03-21 9:14 上午
 **/
public class SausageDecorator extends BattercakeDecorator {
    public SausageDecorator(Battercake battercake) {
        super(battercake);
    }

    @Override
    public String getMag() {
        return super.getMag() + " 加一根香肠";
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 2;
    }
}
