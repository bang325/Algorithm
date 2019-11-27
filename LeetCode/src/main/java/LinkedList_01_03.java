import java.util.Stack;

/**
 * 反转一个单链表。
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * @author Bang
 * @date 2019/8/28  10:36
 */
public class LinkedList_01_03 {
    public static class ListNode{
        public int value;
        public ListNode next;
        public ListNode(int x) {
            this.value = x;
        }
    }
    public ListNode resverList(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode p = resverList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static ListNode reList(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        Stack<Integer> stack = new Stack<>();
        while (head != null){
            stack.push(head.value);
            head = head.next;
        }
        ListNode help = new ListNode(0);
        while (!stack.isEmpty()){
            help.next = new ListNode(stack.pop());
        }
        return help.next;
    }

    //pre, head分别指向前一个Node和当前Node，每次执行head.next = pre
    //nex用于提前保存下一个Node。
    //最后一个 跳出后将最后head指向pre，并返回head。
    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode pre = null, nex = null;
        while(head.next != null) {
            nex = head.next;
            head.next = pre;
            pre = head;
            head = nex;
        }
        head.next = pre;
        return head;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
        reList(head);
        if (head != null){
            System.out.println(head.value + " ");
            head = head.next;
        }
    }
}

