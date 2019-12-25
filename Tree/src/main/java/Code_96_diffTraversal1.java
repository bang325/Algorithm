import java.util.ArrayList;
import java.util.List;

/**
 * @author Bang
 * @date 2019/12/25  10:21
 * G(n)=  i=1∑n  G(i−1)⋅G(n−i)
 */
public class Code_96_diffTraversal1 {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }
    public static int generateTrees(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i=1;i<=n;i++){
            for(int j =1;j<=i;j++){
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
}
