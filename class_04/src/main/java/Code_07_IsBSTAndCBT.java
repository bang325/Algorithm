import com.sun.xml.internal.org.jvnet.mimepull.MIMEConfig;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**判断一棵树是否是搜索二叉树、
 * 思路：中序遍历，升序
 *
 * 判断一棵树是否是完全二叉树
 * @author Bang
 * @date 2019/8/13  16:03
 */
public class Code_07_IsBSTAndCBT {
    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int data){
            this.value = data;
        }
    }
    //中序遍历 搜索二叉树
    public static boolean isBST(Node head){
        System.out.println("中序遍历： ");
        if (head != null){
            int pre = Integer.MIN_VALUE;
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null){
                if (head != null){
                    stack.push(head);
                    head = head.left;
                }else {
                    head = stack.pop();
                    //System.out.println(head.value + " ");
                    if (head.value < pre){
                        return false;
                    }
                    pre = head.value;
                    head = head.right;

                }
            }
        }
        return true;
    }

    //完全二叉树
    public static boolean isCBT(Node head){
        if (head == null){
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        boolean leaf = false;
        Node l = null;
        Node r = null;
        queue.offer(head);
        while (!queue.isEmpty()){
            head = queue.poll();
            l = head.left;
            r = head.right;
            //l == null && r != null  有右孩子 无左孩子 false
            //不是左右节点双全，后面都是叶节点
            //leaf 开启叶节点检查
            if (leaf && (l != null || r != null) ||
                    (l == null && r != null)){
                return false;
            }
            if (l != null){
                queue.offer(l);
            }
            if (r != null){
                queue.offer(r);
            }else {
                leaf = true;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.right = new Node(3);

        System.out.println(isBST(head));
        System.out.println(isCBT(head));

    }

}
