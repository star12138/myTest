package simple;

import java.util.Arrays;

/**
 * @author bike
 *
 * @create 2019-04-18 下午5:20
 **/
public class FizzBuzz {

    public static void main(String[] args) {
        String[] arr = new String[100];
        for (int i = 1; i <= 100; i++){
            int mod3 = i % 3;
            int mod5 = i % 5;

            if (mod3 == 0 || mod5 == 0){
                if (mod3 == 0 && mod5 == 0){
                    arr[i - 1] = "Fizz-Buzz";
                    continue;
                }

                if (mod3 == 0){
                    arr[i - 1] = "Fizz";
                } else {
                    arr[i - 1] = "Buzz";
                }

            } else {
                arr[i - 1] = i + "";
            }
        }
        System.out.println(Arrays.toString(arr));
    }

}
