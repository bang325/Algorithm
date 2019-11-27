/**给定一个链表，判断链表中是否有环。
 * @author Bang
 * @date 2019/8/28  11:35
 */
public class LinkedList_01_06 {
    public static class ListNode{
        public  int value;
        public ListNode next;
        public ListNode(int x){
            this.value = x;
        }
    }
    public static boolean circle(ListNode head){
        if (head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast){
            if (fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = head.next.next;
        System.out.println(circle(head));
    }
}
