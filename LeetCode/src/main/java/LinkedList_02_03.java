/**编写一个程序，找到两个单链表相交的起始节点。
 * 思路：找出链表的长短，长的先走他们的相差数，然后一起走
 *
 * 我们需要做的事情是，让两个链表从同距离末尾同等距离的位置开始遍历。
 *  * 这个位置只能是较短链表的头结点位置。 为此，我们必须消除两个链表的长度差
 *  *
 *  * 指针 pA 指向 A 链表，指针 pB 指向 B 链表，依次往后遍历
 *  * 如果 pA 到了末尾，则 pA = headB 继续遍历
 *  * 如果 pB 到了末尾，则 pB = headA 继续遍历
 *  * 比较长的链表指针指向较短链表head时，长度差就消除了
 *  * 如此，只需要将最短链表遍历两次即可找到位置
 * @author Bang
 * @date 2019/8/28  12:35
 */
public class LinkedList_02_03 {
    public static class ListNode{
        public  int value;
        public ListNode next;
        public ListNode(int x){
            this.value = x;
        }
    }
    public static int common(ListNode node1,ListNode node2){
        if (node1 == null || node2 == null){
            return Integer.MIN_VALUE;
        }
        ListNode pA = node1,pB = node2;
        while (pA != pB){
            //找出相差距离，然后同步
            pA = pA == null ? node2 : pA.next;
            pB = pB == null ? node1 : pB.next;
        }
        return pA.value;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

        ListNode head1 = new ListNode(7);
        head1.next = new ListNode(8);
        head1.next.next = new ListNode(9);
        head1.next.next.next = head.next.next;
        head1.next.next.next.next = head.next.next.next;
        head1.next.next.next.next.next = head.next.next.next.next;

        System.out.println(common(head,head1));
    }
}
