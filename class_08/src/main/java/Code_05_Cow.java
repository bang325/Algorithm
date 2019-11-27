/**
 * 母牛每年生一只母牛，新出生的母牛成长三年后也能每年生一只母牛，
 * 假设不会死。
 * 求N年后，母牛的数量。
 * 思路：F n = F n-1 + F n-3
 *      第N年数量等于前一年数量加上前三年母牛生的数量
 *
 *  进阶：如果每只母牛只能活10年，求N年后，母牛的数量。
 *       F n = F n-1 + F n-3   -    F n-10
 *       第N年数量等于前一年数量加上前三年母牛生的数量 减去前十年的数量
 * @author Bang
 * @date 2019/8/14  21:55
 */
public class Code_05_Cow {
    public static int cowNum(int n){
        if (n < 1){
            return 0;
        }
        if (n == 1 || n == 2 || n == 3){
            return n;
        }
        return cowNum(n-1) + cowNum(n-3) - cowNum(n-10);
    }

    public static void main(String[] args) {
        int n = 11;
        System.out.println(cowNum(n));
    }
}
