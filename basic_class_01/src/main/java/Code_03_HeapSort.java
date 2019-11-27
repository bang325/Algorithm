/**不稳定
 * 堆排序将初始待排序关键字序列(R1,R2….Rn)构建成大顶堆，此堆为初始的无序区；
 * 将堆顶元素R[1]与最后一个元素R[n]交换，
 * 此时得到新的无序区(R1,R2,……Rn-1)和新的有序区(Rn),
 * 且满足R[1,2…n-1]<=R[n]；
 * 由于交换后新的堆顶R[1]可能违反堆的性质，
 * 因此需要对当前无序区(R1,R2,……Rn-1)调整为新堆，
 * 然后再次将R[1]与无序区最后一个元素交换，
 * 得到新的无序区(R1,R2….Rn-2)和新的有序区(Rn-1,Rn)。
 * 不断重复此过程直到有序区的元素个数为n-1，则整个排序过程完成。
 * @author Bang
 * @date 2019/8/7  11:47
 */
public class Code_03_HeapSort {
    public static void heapSort(int[] arr){
        if (arr == null || arr.length <2){
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr,i);
            //形成大根堆之后，调整数组
        }
        int size = arr.length;
        //堆顶是最大数，放在最后，大根堆结构有变化，开始调整
        swap(arr,0,--size);
        while (size>0){
            heapify(arr,0,size);
            swap(arr,0,--size);
        }
    }
    //形成大根堆
    private static void heapInsert(int[] arr, int index) {
        while(arr[index] >arr[(index-1)/2]){
            swap(arr,index,(index-1)/2);
            index = (index-1)/2;
        }
    }
    //数组中有数字有变化，依然形成大根堆
    //size是数组长度
    //index是指发生变化的数字索引
    public static void heapify(int[] arr,int index,int size){
        int left = index*2+1;
        //判断不越界
        while (left < size){
            //右孩子不越界
            //找后继节点
            int largest = left + 1 <size && arr[left+1] > arr[left] ? left+1:left;
            //找到了左右孩子中比index大的下标，在和自己比较，是否比自己大
            largest = arr[largest] > arr[index] ? largest:index;
            if (largest == index){
                break;
            }
            swap(arr,largest,index);
            index = largest;
            left = index*2+1;
        }
    }


    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
