/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * @author Bang
 * @date 2019/8/30  11:06
 */
public class Dynamic_02_03 {
    public static boolean cash(int[] arr , int k){
        for (int i = arr.length-1; i >=0; ) {
            if ( k % arr[i] != 0){
                k = k % arr[i];
                i--;
            }else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {2};
        System.out.println(cash(arr,3));
    }
}
