/**
 * 插入排序——稳定
 * 插入排序（Insertion-Sort）的算法描述是一种简单直观的排序算法。
 * 它的工作原理是通过构建有序序列，对于未排序数据，
 * 在已排序序列中从后向前扫描，找到相应位置并插入。
 * 插入排序在实现上，通常采用in-place排序（即只需用到O(1)的额外空间的排序），
 * 因而在从后向前扫描过程中，
 * 需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。
 * @author Bang
 * @date 2019/8/7  11:15
 */
public class Code_01_InsertionSort {
        public static void insertSort(int[] arr ){
            if (arr == null || arr.length <2){
                return;
            }
            for (int i = 1; i < arr.length; i++) {
                for (int j = i-1; j>=0 && arr[j] > arr[j+1]; j--) {
                    swap(arr,j,j+1);
                }
            }
        }

    private static void swap(int[] arr, int i, int j) {
            arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];
    }
}
