/**
 * 编写一个函数，输入是一个无符号整数，
 * 返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 * @author Bang
 * @date 2019/8/30  13:16
 */
public class Other_01_01 {
    public static int hanmi(int n){
        //在二进制表示中，数字 n 中最低位的 1 总是对应 n−1 中的 0 。
        // 因此，将 n 和n−1 与运算总是能把 n 中最低位的 1变 0，并保持其他位不变。
        //按位“与”操作符，如果两个数的二进制，相同位数都是1，则该位结果是1，否则是0.
        //按位“或”操作符，如果两个数的二进制，相同位数有一个是1，则该位结果是1，否则是0.
        int res = 0;
        while (n != 0){
            res++;
            n &= (n-1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(hanmi(5));
    }
}
