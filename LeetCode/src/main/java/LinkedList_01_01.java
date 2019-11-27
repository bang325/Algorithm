/**
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，
 * 你将只被给定要求被删除的节点。
 * 输入: head = [4,5,1,9], node = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，
 * 那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 *
 * 从链表里删除一个节点 node 的最常见方法是修改之前节点的 next 指针，
 * 使其指向之后的节点。
 *
 * 但是，我们无法访问我们想要删除的节点 之前 的节点，
 * 我们始终不能修改该节点的 next 指针。
 * 相反，我们必须将想要删除的节点的值替换为它后面节点中的值，然后删除它之后的节点。
 * 1-2-3-4-5  删除3
 * 1-2-4-4-5
 * 1-2-4-5
 * @author Bang
 * @date 2019/8/28  9:33
 */
public class LinkedList_01_01 {
    public static class ListNode{
        public int value;
        public ListNode next;
        public ListNode(int x) {
            this.value = x;
        }
    }
    public static ListNode deleteNode(ListNode node,int K) {
        ListNode help = new ListNode(0);
        help.next = node;
        ListNode first = help;
        if (first.value == K){
            first.value = first.next.value;
            first.next = first.next.next;
        }else {
            first = first.next;
        }
        return first.next;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
        deleteNode(head,5);
        if (head != null){
            System.out.println(head.value + " ");
            head = head.next;
        }
    }
}
