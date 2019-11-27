import java.util.Stack;

/**
 * @author Bang
 * @date 2019/11/14  17:56
 */
public class solution {
    public static class TreeNode{
        public TreeNode left;
        public  TreeNode right;
        public int value;
        public TreeNode(int x){
            this.value = x;
        }
    }
    public static int depth(TreeNode head){
        if (head == null){
            return 0;
        }
        return Math.max(depth(head.left),depth(head.right))+1;
    }

    public static void main(String[] args) {
        TreeNode head =new TreeNode(0);
        head.left = new TreeNode(1);

    }
}
