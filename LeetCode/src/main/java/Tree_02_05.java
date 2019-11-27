import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * 中序遍历，输出第K个数
 * @author Bang
 * @date 2019/8/29  10:41
 */
public class Tree_02_05 {
    public static class TreeNode{
        public int value;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int data){
            this.value = data;
        }
    }
    public static int samllK(TreeNode head,int k){
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
        return list.get(k-1);
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(8);
        head.left = new TreeNode(5);
        head.right = new TreeNode(10);
        head.left.left = new TreeNode(3);
        head.right.right = new TreeNode(13);
        System.out.println(samllK(head,3));
    }
}
