/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * @author Bang
 * @date 2019/8/27  13:35
 */
public class Str_01_02 {
    public static long reveInt(long n){
        long tmp = 0;
        while (n != 0){
            long pop = n%10;
            tmp = tmp*10 + pop;
            if (tmp > Integer.MAX_VALUE || tmp < Integer.MIN_VALUE){
                return 0;
            }
            n = n/10;
        }
        return tmp;
    }

    public static void main(String[] args) {
        long n = -132643000;
        System.out.println(reveInt(n));
    }
}
