import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.reverse;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。
 * （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 * @author Bang
 * @date 2019/11/21  13:18
 */
public class Code_107_levelTraversal {
    public static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int data){
            this.val = data;
        }
    }

    public static List<List<Integer>> levels = null;
    public static List<List<Integer>> res = null;

    public static List<List<Integer>> levelOrderBottom(TreeNode root){
        levels = new ArrayList<List<Integer>>() ;
        res = new ArrayList<List<Integer>>();
        if (root == null){
            return null;
        }
        help(root,0);
        Collections.reverse(levels);
        //rev(levels);
        return levels;
    }

    private static void rev(List<List<Integer>> levels) {
        for (int i = levels.size()-1; i >=0; i--) {
            res.add(levels.get(i));
        }
    }

    private static void help(TreeNode root, int level) {
        if (levels.size() == level){
            levels.add(new ArrayList<Integer>());
        }
        levels.get(level).add(root.val);
        if (root.left != null){
            help(root.left,level+1);
        }
        if (root.right !=null){
            help(root.right,level+1);
        }
    }
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(2);
        node.right.left = new TreeNode(3);
        node.left = new TreeNode(18);
        node.left.right = new TreeNode(22);
        System.out.println(levelOrderBottom(node));
    }
}
