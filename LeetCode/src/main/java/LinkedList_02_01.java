import java.util.List;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * @author Bang
 * @date 2019/8/28  11:54
 */
public class LinkedList_02_01 {
    public static class ListNode{
        public  int value;
        public ListNode next;
        public ListNode(int x){
            this.value = x;
        }
    }
    public static ListNode sum(ListNode node1,ListNode node2){
        ListNode node = new ListNode(0);
        ListNode pre = node;
        int carry = 0;
        while (node1 != null || node2 != null){
            int x = node1 == null ? 0 : node1.value;
            int y = node2 == null ? 0 : node2.value;
            int sum = x+y+carry;
            carry = sum / 10;
            sum = sum%10;
            pre.next = new ListNode(sum);
            pre = pre.next;
            if (node1 != null){
                node1 = node1.next;
            }
            if (node2 != null){
                node2 = node2.next;
            }
            if (carry == 1){
                pre.next = new ListNode(1);
            }
        }
        return node.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

        ListNode head1 = new ListNode(6);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(2);
        head1.next.next.next.next = new ListNode(1);

        ListNode res = sum(head,head1);
        while (res != null){
            System.out.print(res.value + " ");
            res = res.next;
        }
    }
}
