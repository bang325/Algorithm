import java.util.Stack;

/**
 * @author Bang
 * @date 2019/9/6  11:31
 */
public class exercise {
    public static int nixu(int[] arr){
        if (arr.length <= 1){
            return 0;
        }
        int res = 0;
        for (int i = arr.length-1; i >0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]){
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,0,3};
        System.out.println(nixu(arr));
        System.out.println(1^3^4^5^5^6);
    }
}
