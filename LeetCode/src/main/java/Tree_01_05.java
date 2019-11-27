import java.util.Stack;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点
 * 的左右两个子树的高度差的绝对值不超过 1。
 * @author Bang
 * @date 2019/8/28  15:19
 */
public class Tree_01_05 {
    public static class TreeNode{
        public int value;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int data){
            this.value = data;
        }
    }
    public static TreeNode sort(int[] arr){
        return toSort(arr,0,arr.length-1);
    }

    private static TreeNode toSort(int[] arr, int l, int r) {
        if (l > r){
            return null;
        }
        int mid = (l+r)/2;
        TreeNode head = new TreeNode(arr[mid]);
        head.left = toSort(arr,l,mid-1);
        head.right = toSort(arr,mid+1,r);
        return head;
    }
    public static void order(TreeNode head){
        if (head == null){
            return;
        }
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
    }

    public static void main(String[] args) {
        int[] arr = {-10,-3,-1,0 ,4,5,7,9};
        order(sort(arr));
    }
}
