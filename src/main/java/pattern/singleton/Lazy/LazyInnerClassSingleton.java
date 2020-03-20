package pattern.singleton.Lazy;

/**
 * 通过静态内部类方式，实现懒汉式单例获取
 * <p>
 * 只有加载当前类之前，才会去加载当前类的，内部类
 * 通过这种方式，避免了线程安全问题
 * jvm底层实现
 *
 * @author bike
 * @create 2020-03-17 10:23 上午
 **/
public class LazyInnerClassSingleton {

    private LazyInnerClassSingleton() {
        /**
         * 通过抛出这个异常，解决通过反射机制去创建实例
         */
        if (LazyHolder.LAZY != null) {
            throw new RuntimeException("请通过指定方式调用");
        }
    }

    /**
     * Class<?> clazz = LazyInnerClassSingleton.class;
     * Constructor c = clazz.getDeclaredConstructor(null);
     * c.setAccessible(true);
     * Object o1 = c.newInstance();
     * Object o2 = LazyInnerClassSingleton.getInstance();
     * System.out.println(o1 == o2);
     * <p>
     * 可以通过反射去进行攻击
     *
     * @return
     */
    public static LazyInnerClassSingleton getInstance() {
        return LazyHolder.LAZY;
    }

    private static class LazyHolder {
        private static final LazyInnerClassSingleton LAZY = new LazyInnerClassSingleton();
    }

    /**
     * 通过这个方法，去控制序列化后，返回的对象
     * 如果没有这个方法，返回的就是通过文件序列化后创建的新的对象
     * 有这个方法，就返回这个方法中的返回值
     *
     * 重写这个方法，还是创建了两次对象
     *
     * @return
     */
    private Object readResolve() {
        return LazyHolder.LAZY;
    }
}
