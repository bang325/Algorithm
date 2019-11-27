/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * @author Bang
 * @date 2019/8/28  10:13
 */
public class LinkedList_01_02 {
    public static class ListNode{
        public int value;
        public ListNode next;
        public ListNode(int x) {
            this.value = x;
        }
    }
    public static ListNode deleteN(ListNode head , int n){
        ListNode help = new ListNode(0);
        help.next = head;
        ListNode first = help;
        ListNode second = help;
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
            //先走N步
        }
        while (first != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return help.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
        deleteN(head,2);
        while (head != null){
            System.out.print(head.value + " ");
            head = head.next;
        }
    }
}
