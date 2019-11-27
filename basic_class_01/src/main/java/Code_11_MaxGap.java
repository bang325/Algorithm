/**给定一个数组，求如果排序之后，相邻两数的最大差值，
 * 要求时 间复杂度O(N)，且要求不能用非基于比较的排序。
 * 思路：不能使用比较排序，使用桶策略，记录桶中最大值和最小值
 * 记录不同桶之间最小值和最大值的差
 * 比较出最大值 输出
 * @author Bang
 * @date 2019/8/9  15:04
 */
public class Code_11_MaxGap {
    public static int maxGap(int[] nums){
        if (nums == null || nums.length<2){
            return 0;
        }
        int len = nums.length;
        //先找出数组中的最大值和最小值
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
        }
        if (min == max){
            return 0;
        }
        boolean[] hasNum = new boolean[len + 1];//记录该桶中是否有数
        int[] maxs = new int[len+1];//记录桶中最大值
        int[] mins = new int[len+1];//记录桶中最小值
        int bid = 0;//桶的序号
        for (int i = 0; i < len; i++) {
            bid = bucket(nums[i],len,min,max);//num[i]放在哪个桶
            //一个桶至多只存一个最大值，一个最小值
            //该桶中的最小值
            mins[bid] = hasNum[bid]? Math.min(mins[bid],nums[i]):nums[i];
            //该桶中的最大值
            maxs[bid] = hasNum[bid]? Math.max(maxs[bid],nums[i]):nums[i];
            //标记该桶有数
            hasNum[bid] = true;
        }
        int res = 0;
        int lastMax = maxs[0];
        for (int i = 1; i <= len; i++) {
            if (hasNum[i]){
                res = Math.max(res,mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;
    }

    private static int bucket(int num, int len, int min, int max) {
        return (int)((num - min) * len / (max - min));
    }
}
