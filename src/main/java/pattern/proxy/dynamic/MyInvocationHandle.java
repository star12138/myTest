package pattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author
 * @create 2020-03-18 9:57 上午
 **/
public class MyInvocationHandle implements InvocationHandler {
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        DogUtils.method1();
        method.invoke(target, args);
        DogUtils.method2();
        return null;
    }
}
