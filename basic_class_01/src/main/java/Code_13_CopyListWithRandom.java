import java.util.HashMap;

/**复制含有随机指针节点的链表
 * 【题目】 一种特殊的链表节点类描述如下：
 * public class Node {
 *     public int value;
 *     public Node next;
 *     public Node rand;
 *     public Node(int data) {
 *         this.value = data; } }
 *  Node类中的value是节点值，next指针和正常单链表中next指针的意义 一 样，
 *  都指向下一个节点，rand指针是Node类中新增的指针，
 *  这个指 针可 能指向链表中的任意一个节点，也可能指向null。
 *  给定一个由 Node节点类型组成的无环单链表的头节点head，
 *  请实现一个 函数完成 这个链表中所有结构的复制，
 *  并返回复制的新链表的头节点。
 *
 *  思路：使用hashmap   将节点拷贝，对应节点指针信息拷贝
 *
 *  进阶： 不使用额外的数据结构，只用有限几个变量，
 *  且在时间复杂度为 O(N) 内完成原问题要实现的函数。
 *
 *  思路：构建新的链表 1——1‘——2——2’——3——3‘
 *  拆分链表
 * @author Bang
 * @date 2019/8/13  9:25
 */
public class Code_13_CopyListWithRandom {
    public static class Node{
        public int value;
        public Node next;
        public Node rand;
        public Node(int data){
            this.value = data;
        }
    }
    //使用额外空间O（n） hashmap
    public static Node copyListWithRand1(Node head){
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        //拷贝整个链表
        while (cur != null){
            map.put(cur,new Node(cur.value));
            cur = cur.next;
        }
        cur = head;
        while (cur != null ){
            map.get(cur).next = map.get(cur.next);//下一指针的拷贝
            map.get(cur).rand = map.get(cur.rand);//随机指针的拷贝
            cur = cur.next;
        }
        return map.get(head);
    }

    //不使用额外空间
    public static Node copyListWithRand2(Node head){
        if (head == null){
            return null;
        }
        Node cur = head;
        Node backup = null;
        // copy node and link to every node
        //原始链表 1——2——3
        //处理后 1——1‘——2——2’——3——3‘
        while (cur != null){
            backup = cur.next;//记录下一指针
            cur.next = new Node(cur.value);
            cur.next.next = backup;
            cur = backup;
        }
        cur = head;
        Node curRand = null;
        // set copy node rand 随机指针拷贝
        while (cur != null){
            backup = cur.next.next;
            curRand = cur.next;
            curRand = cur.rand != null ? cur.rand.next : null;
            cur = backup;
        }
        Node res = head.next;
        cur = head;
        //分离
        while (cur != null){
            backup = cur.next.next;
            curRand = cur.next;
            cur.next = backup;
            curRand.next = backup != null ? backup.next :null;
            cur = backup;
        }
        return res;
    }

    public static void printRandLinkedList(Node head) {
        Node cur = head;
        System.out.print("order: ");
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        System.out.print("rand:  ");
        while (cur != null) {
            System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = null;
        Node res1 = null;
        Node res2 = null;
        printRandLinkedList(head);
        res1 = copyListWithRand1(head);
        printRandLinkedList(res1);
        res2 = copyListWithRand2(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.rand = head.next.next.next.next.next; // 1 -> 6
        head.next.rand = head.next.next.next.next.next; // 2 -> 6
        head.next.next.rand = head.next.next.next.next; // 3 -> 5
        head.next.next.next.rand = head.next.next; // 4 -> 3
        head.next.next.next.next.rand = null; // 5 -> null
        head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

        printRandLinkedList(head);
        res1 = copyListWithRand1(head);
        printRandLinkedList(res1);
        res2 = copyListWithRand2(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");

    }
}
