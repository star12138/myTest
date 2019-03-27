package simple;

/**
 * @author bike
 * @create 2019-03-22 上午9:50
 * <p>
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * <p>
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 * <p>
 * 注意：
 * 0 ≤ x, y < 231.
 * <p>
 * <p>
 * 输入: x = 1, y = 4
 * <p>
 * 输出: 2
 * <p>
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ↑   ↑
 * <p>
 * 上面的箭头指出了对应二进制位不同的位置。
 **/
public class HammingDistance {

    public int hammingDistance(int x, int y) {
        int result = x ^ y;
        String str = Integer.toBinaryString(result);
        result = 0;
        for (char c : str.toCharArray()){
            if (c == 49){
                result++;
            }
        }
        return result;
    }

    public int hammingDistance2(int x, int y) {
        int result = x ^ y;
        String str = Integer.toBinaryString(result);
        return str.replaceAll("0","").length();
    }

    /**
     * 数组中的数都是成对出现，只有一个数不成对
     *
     * 找出，这个不成对的数
     *
     */
    public void test(){
        Integer[] arr = {1,1,4,2,2,3,6,3,4,5,6};
        int a = arr[0];
        for (int i = 1 ; i < arr.length ; i++){
            a = a ^ arr[i];
        }

        System.out.println(a);
    }

    public static void main(String[] args) {
        Integer[] arr = {1,1,4,2,2,3,6,3,4,5,6};
        int a = arr[0];
        for (int i = 1 ; i < arr.length ; i++){
            a = a ^ arr[i];
        }

        System.out.println(a);

    }
}
