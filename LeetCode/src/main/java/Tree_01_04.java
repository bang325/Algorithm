import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。
 * （即逐层地，从左到右访问所有节点）。
 *
 * @author Bang
 * @date 2019/8/28  14:58
 */
public class Tree_01_04 {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int data) {
            this.val = data;
        }
    }

    public static List<List<Integer>> levels = null;

    public static List<List<Integer>> levelOrder(TreeNode root) {
        levels = new ArrayList<List<Integer>>();
        if (root == null) {
            return levels;
        }
        //helper(root, 0);
        helper2(root, 0);
        reverse(levels);
        return levels;
    }

    private static void reverse(List<List<Integer>> levels) {
        if (levels.size() <= 1){
            return;
        }
        for (int i = 1; i < levels.size(); i=i+2) {
            Collections.reverse(levels.get(i));
        }
    }

    private static void helper(TreeNode head, int level) {
        if (levels.size() == level) {
            levels.add(new ArrayList<Integer>());
        }
        levels.get(level).add(head.val);
        if (head.left != null) {
            helper(head.left, level + 1);
        }
        if (head.right != null) {
            helper(head.right, level + 1);
        }
    }

    //zig打印
    private static void helper2(TreeNode head, int level) {
        if (levels.size() == level) {
            levels.add(new ArrayList<Integer>());
        }
        levels.get(level).add(head.val);
        if (head.left != null) {
            helper(head.left, level + 1);
        }
        if (head.right != null) {
            helper(head.right, level + 1);
        }
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(9);
        head.right = new TreeNode(10);
        head.left.left = new TreeNode(13);
        head.right.right = new TreeNode(15);
        System.out.println(levelOrder(head));
    }
}
