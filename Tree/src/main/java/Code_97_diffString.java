/**
 * //我们仅使用一维 dpdp 数组去储存前缀结果。
 * 我们利用 dp[i-1]dp[i−1] 的结果和 dp[i]dp[i] 之前的结果
 * 来计算 dp[i]dp[i] ，即滚动数组。
 * @author Bang
 * @date 2019/12/25  10:47
 */

public class Code_97_diffString {
    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        boolean dp[] = new boolean[s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[j] = true;
                } else if (i == 0) {
                    dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if (j == 0) {
                    dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                } else {
                    dp[j] = (dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
                            (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dp[s2.length()];
    }
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "bad";
        String s3 = "abbacd";
        System.out.println(isInterleave(s1,s2,s3));
    }
}

