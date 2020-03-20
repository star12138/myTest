package pattern.proxy.cglib;

/**
 * @author bike
 * @create 2020-03-18 10:16 上午
 **/
public class CglibProxy {
    public static void main(String[] args) {
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 1000);
        }

        MyEnhancer myEnhancer = new MyEnhancer();

        ArraySort2 arraySort2 = (ArraySort2)myEnhancer.getInstance(ArraySort2.class);
        arraySort2.quickSort(arr);

    }
}
