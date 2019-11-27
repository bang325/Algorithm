import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Bang
 * @date 2019/11/21  11:30
 */
public class Code_104_Depth {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    public static List<List<Integer>> levels = null;

    public static int maxDepth(TreeNode root) {
        levels = new ArrayList<List<Integer>>();
        if (root == null) {
            return levels.size();
        }
        helper2(root, 0);
        return levels.size();
    }

    private static void helper2(TreeNode head, int level) {
        if (levels.size() == level) {
            levels.add(new ArrayList<Integer>());
        }
        levels.get(level).add(head.val);
        if (head.left != null) {
            helper2(head.left, level + 1);
        }
        if (head.right != null) {
            helper2(head.right, level + 1);
        }
    }



    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(2);
        node.right.left = new TreeNode(3);
        node.left = new TreeNode(18);
        node.left.right = new TreeNode(22);
        System.out.println(maxDepth(node));
    }
}
