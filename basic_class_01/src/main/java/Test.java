/**
 * @author Bang
 * @date 2019/11/6  15:32
 */
public class Test {
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        QuickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
    public static void QuickSort(int[] arr ,int l,int r){
        if(l<r){
            int[] p = partition(arr,l,r);//确定值的左右数坐标
            QuickSort(arr,l,p[0]-1);
            QuickSort(arr,p[1]+1,r);
        }
    }
    public static int[] partition(int[] arr,int l ,int r){
        int less = l-1;//从左边的值开始坐标
        int more = r; //记录右边的值坐标
        while(l<more) {
            if (arr[l] < arr[r]) {
                swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                swap(arr, --more, l);
            } else {
                l++;
            }
        }
            swap(arr,more,r);
            return new int[]{less+1,more};
    }
    public static void swap(int[] arr ,int l,int r ){
        //交换值
            int tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,1,1,0,9,7,6};
        quickSort(arr);
    }
}
