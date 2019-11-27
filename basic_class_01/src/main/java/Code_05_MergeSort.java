/**
 * 归并排序——稳定
 * 是采用分治法（Divide and Conquer）的一个非常典型的应用。
 * 归并排序是一种稳定的排序方法。将已有序的子序列合并，
 * 得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。
 * 若将两个有序表合并成一个有序表，称为2-路归并。
 * @author Bang
 * @date 2019/8/7  12:03
 */
public class Code_05_MergeSort {
    public static void mergeSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        MergeSort(arr,0,arr.length-1);
    }

    private static void MergeSort(int[] arr, int l, int r) {
        if (l==r){
            return;
        }
        int mid = 1 +((r - l) >>1);
        MergeSort(arr,0,mid);
        MergeSort(arr,mid+1,r);
        merge(arr,l,mid,r);
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r-l+1];
        int i = 0;
        int p1 = l;
        int p2 = m+1;
        while (p1 <= m && p2 <= r){
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        //两个必有且只有一个越界
        while (p1 <= m){
            help[i++] = arr[p1++];
        }
        while (p2 <= r){
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[l+j] = help[j];
        }
    }
}
