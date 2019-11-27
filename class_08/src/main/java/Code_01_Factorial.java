/**
 * @author Bang
 * @date 2019/8/14  17:48
 */
public class Code_01_Factorial {
    public static int getFactorial1(int n){
        if (n == 1){
            return 1;
        }
        return n*getFactorial1(n-1);
    }
    public static int getFactorial2(int n){
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println(getFactorial1(n));
        System.out.println(getFactorial2(n));
    }
}
