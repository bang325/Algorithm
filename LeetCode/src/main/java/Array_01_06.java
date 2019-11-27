import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * @author Bang
 * @date 2019/8/26  15:31
 */
public class Array_01_06 {
    public static List uinoin(int[] arr1,int[] arr2){
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        List<Integer> list = new ArrayList<Integer>(arr1.length);
        int a=0,b=0;
        while (a<arr1.length && b < arr2.length){
            if (arr1[a] == arr2[b]){
                list.add(arr1[a]);
                a++;
                b++;
            }else if (arr1[a] > arr2[b]){
                b++;
            }else {
                a++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,2,1};
        int[] arr2 = {2,2};
        System.out.println(uinoin(arr1,arr2));
    }
}
