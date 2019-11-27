import java.util.Arrays;
import java.util.HashSet;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任何值在数组中出现至少两次，函数返回 true。
 * 如果数组中每个元素都不相同，则返回 false。
 * [1,2,3,1]
 * 输出: true
 * @author Bang
 * @date 2019/8/26  15:18
 */
public class Array_01_04 {
    public static boolean ismore(int[] arr){
        while (arr.length == 1 ){
            return true;
        }
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i-1]){
                return true;
            }
        }
        return false;
    }
    public static boolean ismore1(int[] arr){
        HashSet<Integer> set = new HashSet<>(arr.length);
        for (int i:arr) {
            set.add(i);
        }
        return set.size() == arr.length ? false : true;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        System.out.println(ismore(arr));
        System.out.println(ismore1(arr));
    }
}
