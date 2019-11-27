import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Bang
 * @date 2019/8/29  9:50
 */
public class Tree_02_02 {
    public static class TreeNode{
        public int value;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int data){
            this.value = data;
        }
    }

    public static List<List<Integer>> zigPrint(TreeNode head){
        ArrayList<List<Integer>> list = new ArrayList<>();
        help(list,head,0);
        int n = list.size();
        for (int i = 0; i < n; i++) {
            if (i % 2 != 0){
                Collections.reverse(list.get(i));
            }
        }
        return list;
    }

    private static void help(ArrayList<List<Integer>> list, TreeNode head, int level) {
        if (list.size() == level){
            list.add(new ArrayList<>());
        }
        list.get(level).add(head.value);
        if (head.left != null){
            help(list,head.left,level+1);
        }
        if (head.right != null){
            help(list,head.right,level+1);
        }
    }


    public static void main(String[] args) {
        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(9);
        head.right = new TreeNode(10);
        head.left.left = new TreeNode(13);
        head.right.right = new TreeNode(15);
        System.out.println(zigPrint(head));
    }
}
