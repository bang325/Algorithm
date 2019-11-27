/**已知一棵完全二叉树，求其节点的个数
 要求：时间复杂度低于O(N)，N为这棵树的节点个数
 思路：完全二叉树右子树左节点到最大一层，左边2^(H-level ) 再遍历右子树
 没到最大一层，右边是一个小的满二叉树 2^(H-level-1），再遍历左边
 * @author Bang
 * @date 2019/8/13  17:05
 */
public class Code_08_CompleteTreeNodeNumber {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }
    public static int nodeNum(Node head){
        if (head == null){
            return 0;
        }
        return bs(head,1,mostLeftLevel(head,1));
    }

    private static int bs(Node head, int level, int h) {
        if (level == h){
            return 1;
        }
        if (mostLeftLevel(head.right,level+1) == h ){
            //右子树的左节点到最大一层
            return (1 << (h - level)) + bs(head.right,level+1,h);
        }else {
            //右子树的左节点没到最大一层
            return (1 << (h-level-1)) + bs(head.left,level+1,h);
        }
    }
    //右子树的左节点是否到最大一层
    private static int mostLeftLevel(Node head, int level) {
        while (head != null){
            level++;
            head = head.left;
        }
        return level-1;
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        System.out.println(nodeNum(head));

    }
}
