import java.util.Arrays;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * @author Bang
 * @date 2019/8/26  15:42
 */
public class Array_01_07 {
    public static int[] plusone(int[] arr){
        for (int i = arr.length-1; i >=0; i--) {
            arr[i]++;
            arr[i] = arr[i]%10;
            if (arr[i] != 0){
                return arr;
            }
        }
        arr = new int[arr.length+1];
        arr[0] = 1;
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {9,9,9,9};
        System.out.println(Arrays.toString(plusone(arr)));
    }
}
