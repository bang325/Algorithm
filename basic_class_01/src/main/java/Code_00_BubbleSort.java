/**
 * 冒泡排序——稳定
 * 冒泡排序是一种简单的排序算法。它重复地走访过要排序的数列，
 * 一次比较两个元素，如果它们的顺序错误就把它们交换过来。
 * 走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。
 * 这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。
 * @author Bang
 * @date 2019/8/7  10:43
 */

public class Code_00_BubbleSort {
    public static void bubbleSort(int[] arr){
        if (arr == null || arr.length < 2){
            return ;
        }
        for (int i = 0; i <= arr.length-1; i++) {
            for (int j = 0 ; j <arr.length-1-i; j++) {
                if (arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];

    }

}
