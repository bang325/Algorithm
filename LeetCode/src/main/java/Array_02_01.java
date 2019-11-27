import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 * @author Bang
 * @date 2019/8/26  18:30
 */
public class Array_02_01 {
    public static List<List<Integer>> threeSum(int[] arr){
        List<List<Integer>> res = new ArrayList<>();
        if (arr.length < 3 ){
            return res;
        }
        Arrays.sort(arr);
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0){
                break;
            }
            if (i > 0 && arr[i] == arr[i-1]){
                continue;//去重
            }
            int l = i+1;
            int r = n-1;
            while (l < r){
                if (arr[i] + arr[l] + arr[r] == 0){
                    res.add(Arrays.asList(arr[i],arr[l],arr[r]));
                    while (l < r && arr[l] == arr[l+1]){
                        l++;//去重
                    }
                    while (l < r && arr[r] == arr[r-1]){
                        r--;//去重
                    }
                    l++;
                    r--;
                }else if (arr[i] + arr[l] + arr[r] > 0){
                    r--;
                }else {
                    l++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(arr));
    }
}
