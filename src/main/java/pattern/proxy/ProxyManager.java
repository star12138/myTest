package pattern.proxy;

/**
 * 这是静态代理
 *
 * 优点：可以做到在不修改目标对象的功能前提下,对目标功能扩展.
 * 缺点:
 *
 * 　　因为代理对象需要与目标对象实现一样的接口,所以会有很多代理类,类太多.同时,一旦接口增加方法,目标对象与代理对象都要维护.
 *
 *
 * 代理类，相当于经纪人
 * @author bike
 * @create 2020-03-18 9:41 上午
 **/
public class ProxyManager implements IStar {

    private IStar star;

    public ProxyManager(){
        super();
    }

    public ProxyManager(IStar star) {
        this.star = star;
    }

    @Override
    public void sing() {
        System.out.println("唱歌前准备");
        star.sing();
        System.out.println("善后工作");
    }

    public static void main(String[] args) {
        IStar star = new Star();
        ProxyManager manager = new ProxyManager(star);
        manager.sing();
    }
}
