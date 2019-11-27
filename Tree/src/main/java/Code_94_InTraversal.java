import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**给定一个二叉树，返回它的中序遍历。
 * @author Bang
 * @date 2019/11/14  9:39
 */
public class Code_94_InTraversal {
    public static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.value = x;
        }
    }
    //递归
    public static ArrayList<Integer> inorderTraversal(TreeNode root){
        ArrayList<Integer> list = new ArrayList<>();
        helper(root,list);
        return list;
    }

    //非递归
    public static ArrayList<Integer> inorderTraversal2(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        TreeNode curr = root;
        if (curr != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || root != null) {
                if (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                } else {
                    curr = stack.pop();
                    list.add(curr.value);
                    curr = curr.right;
                }
            }
        }
        return list;
    }
    private static void helper(TreeNode root, ArrayList<Integer> list) {
        if (root != null){
            if (root.left != null){
                helper(root.left,list);
            }
            list.add(root.value);
            if (root.right != null){
                helper(root.right,list);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(2);
        node.right.left = new TreeNode(3);
        ArrayList res = inorderTraversal(node);
        for (Object tmp :res) {
            System.out.print(tmp);
        }
    }
}
