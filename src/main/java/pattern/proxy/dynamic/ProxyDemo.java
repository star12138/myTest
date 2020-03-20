package pattern.proxy.dynamic;

/**
 * @author bike
 * @create 2020-03-18 10:01 上午
 **/
public class ProxyDemo {
    public static void main(String[] args) {
        IDog dog = new GunDog();
        IDog proxy = (IDog) MyProxyFactory.getProxy(dog);
        proxy.run();
        proxy.eat();
    }
}
