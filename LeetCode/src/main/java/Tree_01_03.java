/**
 * 对称二叉树
 * @author Bang
 * @date 2019/8/28  14:49
 */
public class Tree_01_03 {
    public static class TreeNode{
        public int value;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int data){
            this.value = data;
        }
    }
    public  static boolean isMirror(TreeNode head){
        return is(head,head);
    }

    private static boolean is(TreeNode head, TreeNode head1) {
        if (head == null && head1 == null){
            return true;
        }
        if (head == null || head1 == null){
            return false;
        }
        return (head.value == head1.value) &&
                (is(head.left , head1.right)) &&
                (is(head.right , head1.left));
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(9);
        head.right = new TreeNode(9);
        head.left.left = new TreeNode(15);
        head.right.right = new TreeNode(15);
        System.out.println(isMirror(head));
    }
}
