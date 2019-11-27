/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * @author Bang
 * @date 2019/8/30  11:17
 */
public class Dynamic_02_04 {
    public static int length(int[] arr){
        int[] dp = new int[arr.length];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < arr.length; i++) {
            int max_val = 0;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]){
                    max_val = Math.max(max_val,dp[j]);
                }
            }
            dp[i] = max_val + 1;
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {10,9,2,5,3,7,101,18};
        System.out.println(length(arr));
    }
}
