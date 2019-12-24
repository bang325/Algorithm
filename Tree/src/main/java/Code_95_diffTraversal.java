import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 * 输入: 3
 * 输出:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 思路：
 * 左子树的所有值小于根节点，右子树的所有值大于根节点。
 *
 * 所以如果求 1...n 的所有可能。
 *
 * 我们只需要把 1 作为根节点，[ ] 空作为左子树，[ 2 ... n ] 的所有可能作为右子树。
 *
 * 2 作为根节点，[ 1 ] 作为左子树，[ 3...n ] 的所有可能作为右子树。
 *
 * 3 作为根节点，[ 1 2 ] 的所有可能作为左子树，[ 4 ... n ] 的所有可能作为右子树，然后左子树和右子树两两组合。
 *
 * 4 作为根节点，[ 1 2 3 ] 的所有可能作为左子树，[ 5 ... n ] 的所有可能作为右子树，然后左子树和右子树两两组合。
 * n 作为根节点，[ 1... n ] 的所有可能作为左子树，[ ] 作为右子树。
 *
 * 至于，[ 2 ... n ] 的所有可能以及 [ 4 ... n ] 以及其他情况的所有可能，可以利用上边的方法，把每个数字作为根节点，然后把所有可能的左子树和右子树组合起来即可。
 *
 * 如果只有一个数字，那么所有可能就是一种情况，把该数字作为一棵树。而如果是 [ ]，那就返回 null。
 * @author Bang
 * @date 2019/12/24  11:51
 */
public class Code_95_diffTraversal {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }
    public static void main(String[] args) {
        int n = 3;
        List<TreeNode> ans = generateTrees(n);
        for (Object tmp :ans) {
            System.out.print(tmp.toString());
        }
    }
    public static List<TreeNode> generateTrees(int n){
        List<TreeNode> ans = new ArrayList<>();
        if (n == 0){
            return ans;
        }
        return getAns(1,n);
    }

    private static List<TreeNode> getAns(int start, int end) {
        List<TreeNode> ans = new ArrayList<>();
        //此时没有数据，将null 加入结果中
        if (start > end){
            ans.add(null);
            return ans;
        }
        //只有一个数字，当前数字作为一棵树加入结果中
        if(start == end){
            TreeNode tree = new TreeNode(start);
            ans.add(tree);
            return ans;
        }
        //尝试每个数字作为根节点
        for (int i = start; i <= end; i++) {
            //得到所有可能的左子树
            List<TreeNode> leftTrees = getAns(start,i-1);
            //得到所有可能的右子树
            List<TreeNode> rightTrees = getAns(i+1,end);
            //左子树右子树两两结合
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees){
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    //加入到最终结果中
                    ans.add(root);
                }
            }
        }
        return ans;
    }
}
