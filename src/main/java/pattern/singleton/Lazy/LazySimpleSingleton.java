package pattern.singleton.Lazy;

/**
 * @author bike
 * @create 2020-03-17 9:15 上午
 **/
public class LazySimpleSingleton {
    private volatile static LazySimpleSingleton singleton = null;

    private LazySimpleSingleton() {
    }

    public static LazySimpleSingleton getInstance() {
        if (singleton == null) {
            synchronized (LazySimpleSingleton.class) {
                if (singleton == null) {
                    singleton = new LazySimpleSingleton();
                }
            }
        }
        return singleton;
    }
}
