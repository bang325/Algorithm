/**
 * 选择排序——不稳定
 * 选择排序(Selection-sort)是一种简单直观的排序算法。
 * 它的工作原理：首先在未排序序列中找到最小（大）元素，
 * 存放到排序序列的起始位置，然后，
 * 再从剩余未排序元素中继续寻找最小（大）元素，
 * 然后放到已排序序列的末尾。
 * 以此类推，直到所有元素均排序完毕。
 * @author Bang
 * @date 2019/8/7  11:29
 */
public class Code_02_SelectionSort {
    public static void selectSort(int[] arr){
        if (arr == null || arr.length <2){
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < arr.length ; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap (arr,i,minIndex);
        }

    }
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
