/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 *
 * 思路： 第I层步数与I-1和I-2层有关
 * 所以到达第 i阶的方法总数就是到第 (i-1) 阶和第 (i-2) 阶的方法数之和。
 * @author Bang
 * @date 2019/8/30  9:27
 */
public class Dynamic_01_01 {
    public static int Staris(int n){
        if (n == 1){
            return 1;
        }
        int[] all = new int[n+1];
        all[1] = 1;
        all[2] = 2;
        for (int i = 3; i <= n; i++) {
            all[i] = all[i-1] + all[i-2];
        }
        return all[n];
    }

    public static void main(String[] args) {
        System.out.println(Staris(10));
    }
}
