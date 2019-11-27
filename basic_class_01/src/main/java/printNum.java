import java.util.Scanner;

/**
 * @author Bang
 * @date 2019/8/24  19:49
 */
public class printNum {
    public static int printNum(int n,String str){
        if (n == 1){
            if(str.charAt(0) >= 'A' && str.charAt(0) <= 'Z'){
                return 2;
            }else {
                return 1;
            }
        }
        int res = 0;
        int caps_lock = 1;
        int shift_lock = 2;
        char[] chs = str.toCharArray();
        for (int i = 0; i < chs.length-1; i++) {
            if (chs[i] >= 'A' && chs[i] <= 'Z' && chs[i+1] >= 'A' && chs[i+1] <= 'Z' ){
                 caps_lock ++;
            }else if (chs[i] >= 'a' && chs[i] <= 'z' && chs[i+1] >= 'a' && chs[i+1] <= 'z' ){
                shift_lock = 2;
            }else {
                res += shift_lock;
            }
        }
        res = caps_lock + shift_lock + n;
        return res;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        String str = scn.nextLine();
        scn.close();
        System.out.println(printNum(n,str));
    }
}
