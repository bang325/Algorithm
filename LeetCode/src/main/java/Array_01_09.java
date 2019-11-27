import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * @author Bang
 * @date 2019/8/26  16:03
 */
public class Array_01_09 {
    public static int[] sum(int[] arr,int target){
        HashMap<Integer, Integer> map = new HashMap<>(arr.length);
        int[] res = new int[2];
        for (int i = 0; i < arr.length; i++) {
            if (map.get(target - arr[i]) != null){
                res[0]  = i;
                res[1] = map.get(target - arr[i]);
            }else {
                map.put(arr[i],i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr  = {2,4,6,8,9,10};
        int target = 11;
        System.out.println(Arrays.toString(sum(arr,target)));
    }
}
