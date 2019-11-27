import java.util.ArrayList;
import java.util.Stack;

/**二叉树前序遍历
 * @author Bang
 * @date 2019/11/14  10:41
 */
public class Code_144_preTraversal {
    public static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.value = x;
        }
    }
    public static ArrayList<Integer> preorderTraversal(TreeNode head) {
        //先序：中左右，中出，右进，左进，再左出，右出
        ArrayList<Integer> list = new ArrayList<>();
        if (head != null){
            Stack<TreeNode> stack = new Stack<>();
            stack.add(head);
            //先序：中左右，中出，右进，左进，再左出，右出
            while (!stack.isEmpty()){
                head = stack.pop();
                list.add(head.value);
                System.out.print(head.value + " ");//打印中节点
                if (head.right != null){
                    stack.push(head.right);
                }
                if (head.left != null){
                    stack.push(head.left);
                }
            }
        }
        return list;
    }
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(2);
        node.right.left = new TreeNode(3);
        //preorderTraversal(node);
        ArrayList res = preorderTraversal(node);
        for (Object tmp :res) {
            System.out.print(tmp);
        }
    }
}
