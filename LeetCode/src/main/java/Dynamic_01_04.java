/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。
 * 每间房内都藏有一定的现金，影响你偷窃的唯一制约因素
 * 就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，
 * 系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，
 * 计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 思路：动态规划：
 * arr[i] = Math.max( arr[i-1] , arr[i-2] + arr[i] )
 * @author Bang
 * @date 2019/8/30  10:31
 */
public class Dynamic_01_04 {
    public static int money(int[] arr){
        int[] mon = new int[arr.length+1];
        mon[0] = 0;
        mon[1] = arr[0];
        for (int i = 2; i <= arr.length; i++) {
            mon[i] = Math.max(mon[i-1],mon[i-2] + arr[i-1]);
        }
        return mon[arr.length];
    }

    public static void main(String[] args) {
        int[] arr = {2,7,9,3,1,10};
        System.out.println(money(arr));
    }
}
