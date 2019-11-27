/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，
 * 其余每个元素均出现两次。找出那个只出现了一次的元素。
 * [2,2,1]
 *
 * 思路：相同数字异或为0
 * @author Bang
 * @date 2019/8/26  15:26
 */
public class Array_01_05 {
    public static int OnlyOne(int[] arr){
        if (arr.length == 1){
            return arr[0];
        }
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res = arr[i] ^ res;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2,2,3,3,1};
        System.out.println(OnlyOne(arr));
    }
}
