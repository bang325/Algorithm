import java.util.Arrays;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，
 * 你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * @author Bang
 * @date 2019/8/29  13:11
 */
public class Sort_02_03 {
    public static int Kbig(int[] arr,int k){
        Arrays.sort(arr);
        if (k > arr.length){
            return -1;
        }
        return arr[arr.length-k];
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,5,4,3,2};
        System.out.println(Kbig(arr,4));
    }
}
