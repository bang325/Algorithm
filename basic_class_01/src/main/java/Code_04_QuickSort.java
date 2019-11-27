/**快速排序
 * 通过一趟排序将待排记录分隔成独立的两部分，
 * 其中一部分记录的关键字均比另一部分的关键字小，
 * 则可分别对这两部分记录继续进行排序，以达到整个序列有序。
 * @author Bang
 * @date 2019/8/7  14:37
 */
public class Code_04_QuickSort {
    public static void quickSort(int[] arr){
        if (arr == null || arr.length<2){
            return;
        }
        QuickSort(arr,0,arr.length-1);
    }
    public static void QuickSort(int[] arr,int l,int r){
        if (l<r){
            //打乱数组
            swap(arr,l+(int)(Math.random()*(r-l+1)),r);
            //求出等于给定值区域的左右坐标
            int[] p = partition(arr,l,r);
            QuickSort(arr,l,p[0]-1);
            QuickSort(arr,p[1]+1,r);
        }
    }

    private static int[] partition(int[] arr, int l, int r) {
        int less = l-1;
        int more = r;
        while (l<more){
            if (arr[l] <arr[r]){
                swap(arr,++less,l++);
            }else if(arr[l] > arr[r]){
                swap(arr,--more,l);
            }else{
                l++;
            }
        }
        swap(arr,more,r);
        return new int[]{less+1,more};
    }

    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
