import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Bang
 * @date 2019/11/21  11:32
 * 二叉树锯齿形遍历
 */
public class Code_103_zigTraversal {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }

    public static List<List<Integer>> levels = null;

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        levels = new ArrayList<List<Integer>>();
        if (root == null) {
            return levels;
        }
        helper2(root, 0);
        reverse(levels);
        return levels;
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

    private static void reverse(List<List<Integer>> levels) {
        if (levels.size() <= 1) {
            return;
        }
        for (int i = 1; i < levels.size(); i = i + 2) {
            Collections.reverse(levels.get(i));
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(2);
        node.right.left = new TreeNode(3);
        node.left = new TreeNode(18);
        node.left.right = new TreeNode(22);
        System.out.println(zigzagLevelOrder(node));
    }
}
