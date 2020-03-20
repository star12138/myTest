package pattern.proxy;

/**
 * 被代理的类，相当于明星
 * @author bike
 * @create 2020-03-18 9:40 上午
 **/
public class Star implements IStar {
    @Override
    public void sing() {
        System.out.println("明星唱歌");

    }
}
