import java.util.LinkedList;

/**
 * 滑动窗口最大值
 * 给定一个数组和一个固定大小的窗口，求这个窗口从左向右移动时，
 * 每次窗口中最大的数。重点在于如何更新窗口中的数。
 * 使窗口中存储单调递减的数。最左边保持最大的。
 * 当不更新了且达到滑动窗口的空间，
 * 就要开始丢弃最旧的数，也就是更新左边。
 * @author Bang
 * @date 2019/8/23  13:05
 */
public class Code_04_GetMaxWindows {
    public static int[] getMaxWindows(int[] arr,int w){
        int[] list = new int[arr.length - w +1];//保存结果
        LinkedList<Integer> deque = new LinkedList<>();
        //保存一个从左到右为 从大到小的双端队列，值为数组的下标
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]){
                //如果右端的元素比当前要加入的元素下，就一直弹出
                deque.pollLast();
            }
            deque.add(i);//将i加入队列
            if (i - w == deque.peekFirst()){
                //将过期的删除,（值比当前的最右端小，且达到双端队列的最大值，则左边弹出）
                deque.pollFirst();
            }
            if (i >= w - 1 ){
                //当达到滑动窗口的值时，开始收集
                list[index++] = arr[deque.peekFirst()];
                //最大值收集出来
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {4,3,5,4,3,3,6,7};
        int[] maxWindows = getMaxWindows(arr, 3);
        for (int i = 0; i < maxWindows.length; i++) {
            System.out.print(maxWindows[i] + " ");
        }
    }
}
