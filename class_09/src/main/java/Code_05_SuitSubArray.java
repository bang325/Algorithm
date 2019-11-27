import java.util.Deque;
import java.util.LinkedList;

/**
 * 最大值减去最小值小于或等于num的子数组数量
 *
 * 给定数组arr和整数num，共返回有多少个子数组如下情况
 * max(arr[i..j]) - min(arr[i..j]) <= num
 * max(arr[i..j]) 表示子数组arr[i..j]中的最大值，
 * min(arr[i..j])表示子数组arr[i..j]中的最小值
 *
 * 1、生成两个双端队列qmax 和qmin.
 * 2、令j不断向右移动（j++）,表示arr[i..j]一直向右扩大，
 * 并不断更新qmax和qmin结构，
 * 保证qmax和qmin始终维持动态窗口最大值和最小值的更新结构。
 * 3、当进行完步骤2，
 * 令i向右移动一个位置并对qmax和qmin做出相应的更新做出相应的更新。
 * 4、根据步骤2，步骤3，
 * 依次求出以arr[0],arr[1],arr[2]…..、arr[N-1]
 * 作为第一个元素的子数组中满足条件的数量分别有多少，
 * 累加起来起来的数量就是最终的结果。
 * @author Bang
 * @date 2019/8/23  13:51
 */
public class Code_05_SuitSubArray {
    public static int getNum(int[] arr,int num){
        if(arr == null || arr.length == 0){
            return 0;
        }
        int res = 0;
        int i = 0;
        int j = 0;
        Deque<Integer> qmax = new LinkedList<>();
        Deque<Integer> qmin = new LinkedList<>();
        while(i < arr.length){
            while( j < arr.length){
                //维护窗口最大值
                while(!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]){
                    qmax.pollLast();
                }
                qmax.addLast(j);
                //维护窗口最小值
                while(!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]){
                    qmin.pollLast();
                }
                qmin.addLast(j);
                if(arr[qmax.peekFirst()] - arr[qmin.peekFirst()] > num){
                    break;
                }
                j++;
            }
            res += j - i;
            if(qmax.peekFirst() == i){
                qmax.poll();
            }
            if(qmin.peekFirst() == i){
                qmin.poll();
            }
            i++;
        }
        return res;
    }
    public static void main(String[] args) {
        int[] a = {1,2,7};
        int n = 4;
        System.out.println( getNum(a, n));
    }
}
