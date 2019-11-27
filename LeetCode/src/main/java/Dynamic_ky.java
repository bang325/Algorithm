/**
 * @author Bang
 * @date 2019/11/5  16:44
 */
public class Dynamic_ky {
    public static String shortenstSeq(String str1, String str2) {
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();
        int m = str1.length();
        int n = str2.length();
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                    //dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        //int index = dp[m][n];
        StringBuffer str = new StringBuffer();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                str.append(c1[i-1]);
                i--;
                j--;
                //index--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                str.append(c2[j-1]);
                j--;
                //index--;
            } else {
                str.append(c1[i-1]);
                i--;
                //index--;
            }
        }
        while (i > 0) {
            str.append(c1[i-1]);
            i--;
            //index--;
        }
        while (j > 0) {
            str.append(c2[j-1]);
            j--;
            //index--;
        }
        return str.reverse().toString();
    }
    public static void main(String[] args) {
        String str1 = "AGGTAB";
        String str2 = "GXTXAYB";
        System.out.println(shortenstSeq(str1, str2));
    }
}
