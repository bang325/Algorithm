/**
 * （荷兰国旗问题）
 * 给定一个数组arr，和一个数num，请把小于num的数放在数组的 左边，
 * 等于num的数放在数组的中间，
 * 大于num的数放在数组的 右边。
 * 思路：划分左中右区域，左边小于，中间等于，右边大于
 * @author Bang
 * @date 2019/8/7  14:09
 */
public class Code_08_NetherlandsFlag {
    public static int[] partition(int[] arr,int l,int r ,int num){
        int less = l-1;
        int more = r+1;
        while (l<more){
            if (arr[l] < num){
                swap(arr,++less,l++);
            }else if (arr[l] > num){
                swap(arr,--more,l);
            }else {
                l++;
            }
        }
        //返回等于区域的左边界，右边界
        return new int[]{less+1,more-1};
    }

    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] + arr[j];
        arr[i] = arr[i] + arr[j];
    }
}
