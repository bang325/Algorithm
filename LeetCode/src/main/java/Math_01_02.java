/**质数个数
 *
 * // 介绍：改算法在寻找素数时，采用了一种与众不同的方法：先将 2－N 的各数放入表中，
 * 然后在 2 的上面画一个圆圈，然后划去 2 的其他倍数；
 * // 第一个既未画圈又没有被划去的数是 3，将它画圈，再划去 3 的其他倍数；
 * 现在既未画圈又没有被划去的第一个数是 5，将它画圈，
 * // 并划去5的其他倍数……依次类推，一直到所有小于或等于N的各数都画了圈或划去为止。
 *
 * // 这时，表中画了圈的以及未划去的那些数正好就是小于 N 的质数。
 *
 * // 普通方法会出现超时，所以只能以空间换时间，采用一个数组来进行标记是否是质数。
 * @author Bang
 * @date 2019/8/30  12:05
 */
public class Math_01_02 {
    public static int zhishu(int n){
        int res = 0;
        boolean[] arr =new boolean[n];
        for (int i = 2; i < n; i++) {
            arr[i] = true;
        }
        for (int i = 2; i*i < arr.length; i++) {
            if (arr[i]){
                for (int j = i*i; j < arr.length; j+=i) {
                    arr[j] = false;
                }
            }
        }
        for (boolean bool:arr) {
            res += bool ? 1 : 0;
        }
        return res;
    }

    public static boolean zhi(int x){
        boolean isPrime = true;
        if(x ==1 || x %2 ==0 && x !=2 )
        {
            isPrime = false;
        }else {
            for( int i =3; i< Math.sqrt(x); i+=2)
            {
                if( x % i == 0)
                {
                    isPrime = false;
                    break;
                }
            }
        }
        return isPrime;
    }

    public static void main(String[] args) {

        System.out.println(zhishu(17));
        System.out.println(zhi(7));
    }
}
