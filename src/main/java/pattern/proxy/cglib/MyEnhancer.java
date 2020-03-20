package pattern.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author bike
 * @create 2020-03-18 10:51 上午
 **/
public class MyEnhancer implements MethodInterceptor {

    public Object getInstance(Class<?> clazz) {
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        long start = System.currentTimeMillis();
        proxy.invokeSuper(obj, args);
        long end = System.currentTimeMillis();
        System.out.println("本次的执行时间为: " + (end - start) + "ms");
        return null;
    }
}
