/**
 * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
 * 数学表达式如下:
 * 如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
 * 使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
 * @author Bang
 * @date 2019/8/27  13:05
 */
public class Array_02_06 {
    public static boolean increaseStr(int[] arr){
        if (arr.length < 3){
            return false;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                for (int k = j+1; k < arr.length; k++) {
                    if (arr[k] > arr[j] && arr[j] > arr[i] ){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean increaseStr1(int[] arr){
        if (arr.length < 3){
            return false;
        }
        int one = Integer.MAX_VALUE;
        int two = Integer.MAX_VALUE;
        for (int n:arr) {
            if (n <= one){
                one = n;
            }else if (n <= two){
                two = n;
            }else {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,2,2,3};
        System.out.println(increaseStr(arr));
        System.out.println(increaseStr1(arr));
    }
}
