import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Bang
 * @date 2019/9/10  17:21
 */
public class Other_01_06 {
    public static int miss(int[] arr){
        Arrays.sort(arr);
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i-1] != 1){
                res = arr[i] -1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        HashMap map = new HashMap();
        int[] arr = {1,5,6,4,3};
        System.out.println(miss(arr));
    }
}
