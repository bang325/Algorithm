import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * @author Bang
 * @date 2019/9/27  13:42
 */
public class Tree_01_06_BFS {

    public static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int data) {
            this.value = data;
        }
    }

    private static ArrayDeque level(TreeNode head) {
        if (head == null){
            System.out.println("树空");
        }
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.add(head);
        while (!deque.isEmpty()){
            TreeNode post = deque.pop();
            System.out.print(post.value + " ");
            if (post.left != null){
                deque.add(post.left);
            }
            if (post.right != null){
                deque.add(post.right);
            }
        }
        return deque;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(9);
        head.right = new TreeNode(9);
        head.left.left = new TreeNode(15);
        head.left.left.left = new TreeNode(18);
        head.left.left.right = new TreeNode(18);
        head.right.right = new TreeNode(15);
        head.right.right.left = new TreeNode(20);
        head.right.right.right = new TreeNode(20);
        System.out.println(level(head));
        System.out.println("================= ");

        if (head == null){
            System.out.println("树空");
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()){
            TreeNode post = stack.pop();
            System.out.print(post.value + " ");
            if (post.right != null){
                stack.push(post.right);
            }
            if (post.left != null){
                stack.push(post.right);
            }
        }
    }

}
