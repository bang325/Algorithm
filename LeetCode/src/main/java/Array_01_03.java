import java.util.Arrays;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * @author Bang
 * @date 2019/8/26  15:00
 */
public class Array_01_03 {
    public static void resver(int[] arr ,int start,int end){
        while (start < end){
            int tmp = arr[end];
            arr[end] = arr[start];
            arr[start] = tmp;
            start++;
            end--;
        }
    }

    public static int[] oneResver(int[] arr,int k){
        k = k % arr.length;
        resver(arr,0,arr.length-1);
        resver(arr,0,k-1);
        resver(arr,k,arr.length-1);
        return  arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        int k = 3;
        System.out.println(Arrays.toString(oneResver(arr,k)));
    }
}
