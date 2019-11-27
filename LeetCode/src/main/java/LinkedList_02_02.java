/**
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
 * 请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，
 * 时间复杂度应为 O(nodes)，nodes 为节点总数。
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * @author Bang
 * @date 2019/8/28  12:14
 */
public class LinkedList_02_02 {
    public static class ListNode{
        public  int value;
        public ListNode next;
        public ListNode(int x){
            this.value = x;
        }
    }
    public static ListNode oddEven(ListNode head){
        if (head == null){
            return null;
        }
        ListNode odd = head,even = head.next,evenhead = even;
        while (even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;//奇数指针后移
            even.next = odd.next;
            even = even.next;//偶数指针后移
        }
        odd.next = evenhead;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

        ListNode res = oddEven(head);
        while (res != null){
            System.out.print(res.value + " ");
            res = res.next;
        }
    }
}
