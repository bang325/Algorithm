import java.util.Arrays;

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 * @author Bang
 * @date 2019/8/27  13:19
 */
public class Str_01_01 {
    public static String[] reverseChar(String[] chs){
        if (chs.length == 1 || chs.length == 0){
            return chs;
        }
        int l = 0, r = chs.length-1;
        while(l < r){
            String tmp = chs[l];
            chs[l] = chs[r];
            chs[r] = tmp;
            l++;
            r--;
        }
        return chs;
    }

    public static void main(String[] args) {
        String[] chs = {"h","e","l","l","o"};
        System.out.println(Arrays.toString(reverseChar(chs)));
    }
}
