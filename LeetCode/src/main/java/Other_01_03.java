/**
 * 颠倒给定的 32 位无符号整数的二进制位。
 * @author Bang
 * @date 2019/8/30  13:31
 */
public class Other_01_03 {
    public static int diandao(int n){
        int res = 0;
        for (int i = 0; i < 32; i++) {
            // 1. 将给定的二进制数,由低到高位逐个取出
            // 1.1 右移 i 位,
            int tmp = n >> i;
            // 1.2  取有效位
            tmp = tmp & 1;
            // 2. 然后通过位运算将其放置到反转后的位置.
            tmp = tmp << (31 - i);
            // 3. 将上述结果再次通过运算结合到一起
            res |= tmp ;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(diandao(43261596));
    }
}
