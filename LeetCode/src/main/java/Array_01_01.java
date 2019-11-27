/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，
 * 使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * @author Bang
 * @date 2019/8/26  14:42
 */
public class Array_01_01 {
    public static int deleArr(int[] arr){
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[res]){
                res++;
                arr[res] = arr[i];
            }
        }
        return res+1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2,2,2,3,3,3};
        System.out.println(deleArr(arr));
    }
}
