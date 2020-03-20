package pattern.proxy.dynamic;

import java.lang.reflect.Proxy;

/**
 * 使用JDK动态代理有一个限制,就是被代理的对象必须实现一个或多个接口
 * 生产代理对象的工厂
 * @author bike
 *
 * @create 2020-03-18 9:59 上午
 **/
public class MyProxyFactory {
    public static Object getProxy(Object target) {
        MyInvocationHandle handle = new MyInvocationHandle();
        handle.setTarget(target);
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handle);
        return proxy;
    }
}
