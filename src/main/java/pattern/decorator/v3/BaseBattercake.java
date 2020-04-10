package pattern.decorator.v3;

/**
 * @author
 * @create 2020-03-21 9:07 上午
 **/
public class BaseBattercake extends Battercake {
    @Override
    public String getMag() {
        return "煎饼";
    }

    @Override
    public int getPrice() {
        return 5;
    }
}
