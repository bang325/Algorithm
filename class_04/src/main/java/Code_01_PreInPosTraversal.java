import java.util.Stack;

/**实现二叉树的先序、中序、后序遍历，
 * 包括递归方式和非递归 方式
 * @author Bang
 * @date 2019/8/13  11:44
 */
public class Code_01_PreInPosTraversal {
    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int data){
            this.value = data;
        }
    }
    public static void preOrderRecur(Node head){
        if (head == null){
            return;
        }
        System.out.print(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    public static void inOrderRecur(Node head){
        if (head == null){
            return;
        }
        inOrderRecur(head.left );
        System.out.print(head.value + " ");
        inOrderRecur(head.right);
    }
    public static void posOrderRecur(Node head){
        if (head == null){
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.value + " ");
    }

    //非递归方式先序
    public static void preOrderUnRecur(Node head){
        System.out.println("pre-order: ");
        if (head != null){
            Stack<Node> stack = new Stack<>();
            stack.add(head);
            //先序：中左右，中出，右进，左进，再左出，右出
            while (!stack.isEmpty()){
                head = stack.pop();
                System.out.print(head.value + " ");//打印中节点
                if (head.right != null){
                    stack.push(head.right);
                }
                if (head.left != null){
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

    //非递归方式中序
    //当前节点为空，从栈哪一个打印，当前节点向右走
    //当前节点不为空，当前压入栈，当前节点向左
    public static void inOrderUnRecur(Node head){
        System.out.println("in-order: ");
        if (head != null){
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null){
                if (head != null){
                    stack.push(head);
                    head = head.left;
                }else {
                    head = stack.pop();
                    System.out.println(head.value + " ");
                    head = head.right;
                }

            }
        }
        System.out.println();
    }

    ////非递归方式后序
    //后序遍历  左右中，思路：先序是中左右，创建中右左的序列
    //                          放入栈，出栈就是左右中
    public static void posOrderUnRecur(Node head){
        System.out.println("pos-order: ");
        if (head != null){
            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();
            //参考先序
            stack1.push(head);
            while (!stack1.isEmpty()) {
                head = stack1.pop();
                stack2.push(head);
                if (head.left != null) {
                    stack1.push(head.left);
                }
                if (head.right != null) {
                    stack1.push(head.right);
                }
            }
                while (!stack2.isEmpty()){
                    System.out.println(stack2.pop().value + " ");
                }
        }
        System.out.println();
    }
    //使用一个栈完成后续
    public static void posOrderUnRecur2(Node h) {
        System.out.print("pos-order: ");
        if (h != null) {
            Stack<Node> stack = new Stack<Node>();
            stack.push(h);
            Node c = null;
            while (!stack.isEmpty()) {
                c = stack.peek();
                if (c.left != null && h != c.left && h != c.right) {
                    stack.push(c.left);
                } else if (c.right != null && h != c.right) {
                    stack.push(c.right);
                } else {
                    System.out.print(stack.pop().value + " ");
                    h = c;
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);

        // recursive
        System.out.println("==============recursive==============");
        System.out.print("pre-order: ");
        preOrderRecur(head);
        System.out.println();
        System.out.print("in-order: ");
        inOrderRecur(head);
        System.out.println();
        System.out.print("pos-order: ");
        posOrderRecur(head);
        System.out.println();

        // unrecursive
        System.out.println("============unrecursive=============");
        preOrderUnRecur(head);
        inOrderUnRecur(head);
        posOrderUnRecur(head);
        posOrderUnRecur2(head);

    }
}
