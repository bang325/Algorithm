import java.util.Arrays;

/**给定一个包含红色、白色和蓝色，一共 n 个元素的数组，
 * 原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * @author Bang
 * @date 2019/8/29  11:47
 */
public class Sort_02_01 {
    public static int[] RWB(int[] arr){
        if (arr == null || arr.length == 1){
            return arr;
        }
        int l = 0;
        int less = -1;
        int more = arr.length;
        int flag = 1;
        while (l < more){
            if (arr[l] < flag){
                swap(arr,++less,l++);
            }else if (arr[l] > flag){
                swap(arr,--more,l);
            }else {
                l++;
            }
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,1,2,2,2,0,0,2,2};
        System.out.println(Arrays.toString(RWB(arr)));
    }
}
