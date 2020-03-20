package pattern.singleton.Lazy;

import java.lang.reflect.Constructor;

/**
 * @author bike
 * @create 2020-03-17 10:34 上午
 **/
public class LazyInnerClassSingletonTest {
    public static void main(String[] args) {
        try {
            Class<?> clazz = LazyInnerClassSingleton.class;
            Constructor c = clazz.getDeclaredConstructor(null);
            c.setAccessible(true);
            Object o1 = c.newInstance();
            Object o2 = LazyInnerClassSingleton.getInstance();
            System.out.println(o1 == o2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
