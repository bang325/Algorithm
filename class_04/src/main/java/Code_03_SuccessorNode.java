/**在二叉树中找到一个节点的后继节点
 * 【题目】 现在有一种新的二叉树节点类型如下：
 *          public class Node {
 *          public int value;
 *          public Node left;
 *          public Node right;
 *          public Node parent;
 *          public Node(int data) {
 *          this.value = data; } }
 该结构比普通二叉树节点结构多了一个指向父节点的parent指针。
 假 设有一 棵Node类型的节点组成的二叉树，
 树中每个节点的parent指针 都正确地指向 自己的父节点，
 头节点的parent指向null。只给一个在 二叉树中的某个节点 node，
 请实现返回node的后继节点的函数。
 在二 叉树的中序遍历的序列中， node的下一个节点叫作node的后继节点。
 * 思路：该节点有右子数——该节点的后继结点是它右子树的最左节点
 *       该节点没有右子树——找父节点，若该节点是父节点的左孩子，
 *       该父节点是后继结点
 *
 *  找前驱节点：若该节点有左子树，前驱是左子树的最右节点
 *              若该节点没有左子树，找父节点，该节点是其父节点的右孩子，
 *              则该父节点是前驱
 * @author Bang
 * @date 2019/8/13  13:22
 */
public class Code_03_SuccessorNode {
    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node parent;
        public Node(int data){
            this.value = data;
        }
    }
    //找后记节点
    public static Node getSuccessorNode(Node node){
        if (node == null){
            return node;
        }
        if (node.right != null){
            return getLeftMost(node.right);
        }else {
           Node parent = node.parent;
           while (parent != null && parent.left != node){
               node = parent;
               parent = node.parent;//向上找父节点
           }
           return parent;
        }
    }

    private static Node getLeftMost(Node node) {
        if (node == null){
            return node;
        }
        while (node.left != null){
            node = node.left;
        }
        return node;
    }

    //找前驱节点
    public static Node getFrontNode(Node node){
        if (node == null){
            return node;
        }
        if (node.left != null){
            return getRightMost(node.left);
        }else {
            Node parent = node.parent;
            while (parent != null && parent.right != node){
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    private static Node getRightMost(Node node) {
        if (node == null){
            return node;
        }
        while (node.right != null){
            node = node.right;
        }
        return node;
    }

    public static void main(String[] args) {
    Node head = new Node(6);
    head.parent = null;
    head.left = new Node(3);
    head.left.parent = head;
    head.left.left = new Node(1);
    head.left.left.parent = head.left;
    head.left.left.right = new Node(2);
    head.left.left.right.parent = head.left.left;
    head.left.right = new Node(4);
    head.left.right.parent = head.left;
    head.left.right.right = new Node(5);
    head.left.right.right.parent = head.left.right;
    head.right = new Node(9);
    head.right.parent = head;
    head.right.left = new Node(8);
    head.right.left.parent = head.right;
    head.right.left.left = new Node(7);
    head.right.left.left.parent = head.right.left;
    head.right.right = new Node(10);
    head.right.right.parent = head.right;

    Node test = head.left.left;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		System.out.println(test.value + " front: " + getFrontNode(test));
        System.out.println("=============1===============");
    test = head.left.left.right;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		System.out.println(test.value + " front: " + getFrontNode(test).value);
        System.out.println("=============2===============");
    test = head.left;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		System.out.println(test.value + " front: " + getFrontNode(test).value);
        System.out.println("=============3===============");
    test = head.left.right;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		System.out.println(test.value + " front: " + getFrontNode(test).value);
        System.out.println("==============4==============");
    test = head.left.right.right;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		System.out.println(test.value + " front: " + getFrontNode(test).value);
        System.out.println("=============5===============");
    test = head;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		System.out.println(test.value + " front: " + getFrontNode(test).value);
        System.out.println("==============6==============");
    test = head.right.left.left;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		System.out.println(test.value + " front: " + getFrontNode(test).value);
        System.out.println("==============7==============");
    test = head.right.left;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		System.out.println(test.value + " front: " + getFrontNode(test).value);
        System.out.println("===============8=============");
    test = head.right;
		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		System.out.println(test.value + " front: " + getFrontNode(test).value);
        System.out.println("===============9=============");
    test = head.right.right; // 10's next is null
		System.out.println(test.value + " next: " + getSuccessorNode(test));
		System.out.println(test.value + " front: " + getFrontNode(test).value);
        System.out.println("==============10==============");
}

}
