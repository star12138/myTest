package jvm;

/**
 * @author bike
 * @create 2019-11-18 3:54 PM
 **/
public class InternTest {
    public static void main(String[] args) {
        String s = new String("a"); // 栈中的引用
        s.intern(); // 存在，直接返回栈中的引用；不存在，在栈中新建引用
        String s1 = "a"; // 堆中的引用
        System.out.println(s == s1);

        String s2 = new String("a") + new String("a");
        s2.intern(); // 存在，返回栈中的引用；不存在，堆中存在，将堆中的引用推送到常量池中；不存在，堆中也不存在，常量池创建，并返回引用
        String s3 = "aa";
        System.out.println(s2 == s3);


        String s5 = new String("aaa");
        s5.intern();
        String s6 = "aaa";
        System.out.println(s5 == s6);


    }
}
