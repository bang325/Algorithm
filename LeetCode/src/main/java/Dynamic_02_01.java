/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 *
 * @author Bang
 * @date 2019/8/30  10:42
 */
public class Dynamic_02_01 {
    public static boolean rip(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            sum += arr[i] - 1;
        }
        return sum+1 >= arr.length-1;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,1,4};
        int[] arr1 = {3,2,1,0,4};
        System.out.println(rip(arr));
        System.out.println(rip(arr1));
    }
}
