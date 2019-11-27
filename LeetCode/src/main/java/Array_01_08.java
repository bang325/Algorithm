import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，
 * 同时保持非零元素的相对顺序。
 * 思路：将所有非零数字放在前i个位置
 * 后面的用0补齐
 * @author Bang
 * @date 2019/8/26  15:52
 */
public class Array_01_08 {
    public static int[] zero(int[] arr){
        int i = 0;//记录非零元素个数
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != 0){
                arr[i] = arr[j];
                i++;
            }
        }
        for (int p = i; p < arr.length; p++) {
            arr[p] = 0;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1,0,3,4,0,5};
        System.out.println(Arrays.toString(zero(arr)));
    }
}
