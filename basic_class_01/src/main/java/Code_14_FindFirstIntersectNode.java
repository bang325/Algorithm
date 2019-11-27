/**两个单链表相交的一系列问题
 * 【题目】 在本题中，单链表可能有环，也可能无环。
 * 给定两个 单链表的头节点 head1和head2，这两个链表可能相交，
 * 也可能 不相交。
 * 请实现一个函数， 如果两个链表相交，
 * 请返回相交的 第一个节点；如果不相交，返回null 即可。
 * 要求：如果链表1 的长度为N，链表2的长度为M，
 * 时间复杂度请达到 O(N+M)，额外 空间复杂度请达到O(1)。
 *
 * 思路：先判断两链表是否有环
 * 1、无环链表，相交  输出相交节点
 * 2、有环链表，若相交，输出链表相交节点
 *              有环三种可能  6 6 型    上Y下O型   上||下O 型
 * @author Bang
 * @date 2019/8/13  10:36
 */
public class Code_14_FindFirstIntersectNode {
    public static class Node{
        public int value;
        public Node next;
        public Node(int data){
            this.value = data;
        }
    }
    //相交节点
    public static Node getIntersectNode(Node head1,Node head2){
        if (head1 == null || head2 == null){
            return null;
        }
        Node loop1 = getLoopNode(head1);//head1第一个入环节点
        Node loop2 = getLoopNode(head2);//head2第一个入环节点
        if (loop1 == null && loop2 == null){
            return noLoop(head1,head2);//两个无环链表相交问题
        }
        if (loop1 != null && loop2 != null){
            //两个有环链表相交问题
            return bothLoop(head1,loop1,head2,loop2);
        }
        return null;
    }

    private static Node getLoopNode(Node node) {
        if (node == null || node.next == null ||node.next.next == null){
            return null;
        }
        Node n1 = node.next;//n1 慢指针
        Node n2 = node.next.next ;//n2 快指针
        //n1 == n2时，肯定有环，环节点是将慢指针拨到开始节点，
        // 和快指针一起向前进，每次前进一步，直到相遇，就是相交节点
        while (n1 != n2){
            if (n2.next == null || n2.next.next == null){
                return null;
            }
            n2 = n2.next.next;
            n1 = n1.next;
        }
        n1 = node;
        while (n1 != n2){
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;//返回相交节点

    }
    private static Node noLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null){
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        while (cur1.next != null){
            //求出cur1的长度
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null){
            //求出cur2的长度
            n--;
            cur2 = cur2.next;
        }
        //比较的是内存地址，不相等时肯定无相交节点
        if (cur1 != cur2){
            return null;
        }
        //定位谁是长链表，谁是短链表
        cur1 = n > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;
        n = Math.abs(n);
        while (n != 0){
            n--;
            cur1 = cur1.next;//长链表先走n步
        }
        //再和短链表一起走，相等时第一个即为相交链表
        while (cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }
    //有环链表相交
    private static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        Node cur1 = null;
        Node cur2 = null;
        if (loop1 ==loop2){
            //上Y下O型
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1 != loop1){
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2){
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0){
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2){
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }else {
            //6 6 型   或者  上||下O 型
            cur1 = loop1.next;
            //上||下O 型
            while (cur1 != loop1){
                if (cur1 == loop2){
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }

    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

    }

}
