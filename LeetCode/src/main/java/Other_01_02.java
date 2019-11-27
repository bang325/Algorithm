/**
 * 汉明距离
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 * 思路：m ^ n 得到的值有多少个1，就是最终结果
 * @author Bang
 * @date 2019/8/30  13:20
 */
public class Other_01_02 {
    public static int hanmi2(int m , int n){
        int a = m ^ n;
        //按位“异或”操作符，如果两个数的二进制，
        //相同位数只有一个是1，则该位结果是1，否则是0
        int res = 0;
        while (a != 0){
            res++;
            a &= (a-1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(hanmi2(1,5));
    }
}
