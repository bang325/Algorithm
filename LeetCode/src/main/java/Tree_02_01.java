import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 * @author Bang
 * @date 2019/8/29  9:22
 */
public class Tree_02_01 {
    public static class TreeNode{
        public int value;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int data){
            this.value = data;
        }
    }
    public static void Order(TreeNode head){
        System.out.println("中序： ");
        if (head != null){
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || head != null){
                if (head != null){
                    stack.push(head);
                    head = head.left;
                }else {
                    head = stack.pop();
                    System.out.print(head.value + " ");
                    head = head.right;
                }
            }
        }
        System.out.println(" ");
    }

    public static List<Integer> order2(TreeNode head){
        System.out.println("中序2： ");
        List<Integer> list = new ArrayList<>();
        if (head != null){
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || head != null){
                if (head != null){
                    stack.push(head);
                    head = head.left;
                }else {
                    head = stack.pop();
                    list.add(head.value);
                    head = head.right;
                }
            }
        }
        return list;
    }
    public static void main(String[] args) {
        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(9);
        head.right = new TreeNode(10);
        head.left.left = new TreeNode(13);
        head.right.right = new TreeNode(15);
        Order(head);
        System.out.println(order2(head));
    }
}
