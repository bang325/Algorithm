import java.util.Arrays;

/**
 * @author Bang
 * @date 2019/8/15  12:13
 */
public class min {
    public static int missMinNum(int[] arr){
        Arrays.sort(arr);
        int l = 0;
        while (arr[l] < 0 ){
            l++;
        }
        int r = 1;
        while (arr[l] == r ){
            if (l == arr.length-1){
                return ++r;
            }
            l++;
            r++;
        }
        return r;
    }

    public static void main(String[] args) {
        int[] arr = {-1,2,3,4};
        int[] arr1 = {1,2,3,4};
        System.out.println(missMinNum(arr));
        System.out.println(missMinNum(arr1));
    }
}
