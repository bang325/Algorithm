/**
 * 给定一个整数数组 nums ，
 * 找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 动态规划的是首先对数组进行遍历，当前最大连续子序列和为 sum，结果为 ans
 * 如果 sum > 0，则说明 sum 对结果有增益效果，则 sum 保留并加上当前遍历数字
 * 如果 sum <= 0，则说明 sum 对结果无增益效果，需要舍弃，则 sum 直接更新为当前遍历数字
 * 每次比较 sum 和 ans的大小，将最大值置为ans，遍历结束返回结果
 * @author Bang
 * @date 2019/8/30  10:16
 */
public class Dynamic_01_03 {
    public static int Maxsub(int[] arr){
        int ans = arr[0];
        int sum = 0;
        for (int a:arr){
            if (sum > 0){
                sum += a;
            }else {
                sum = a;
            }
            ans = Math.max(ans,sum);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(Maxsub(arr));
    }
}
