import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 思路：中序遍历，递增序列
 * @author Bang
 * @date 2019/8/28  13:34
 */
public class Tree_01_02 {
    public static class TreeNode{
        public int value;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int data){
            this.value = data;
        }
    }
    public static List<Integer>  isvalid(TreeNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        if (head != null){
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || head != null){
            if (head != null){
                stack.push(head);
                head = head.left;
            }else {
                head = stack.pop();
                System.out.print(head.value+ " ");
                list.add(head.value);
                head = head.right;
            }
        }
    }
        return list;
    }
    //有问题
    public static boolean isValid(TreeNode head){
        int tmp = Integer.MIN_VALUE;
        if(head == null) {
            return true;
        }
        if (isValid(head.left)) {
            if (tmp < head.value) {
                tmp = head.value;
                return isValid(head.right);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(9);
        head.right = new TreeNode(20);
        head.right.left = new TreeNode(15);
        head.right.right = new TreeNode(7);
        System.out.println("in-order: ");
        System.out.println(isvalid(head));
    }
}

