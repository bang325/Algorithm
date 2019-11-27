import java.util.Stack;

/**
 * 回文链表
 * @author Bang
 * @date 2019/8/28  11:28
 */
public class LinkedList_01_05 {
    public static class ListNode{
        public int value;
        public ListNode next;
        public ListNode(int x){
            this.value = x;
        }
    }
    public static boolean paliList(ListNode head){
        if (head == null || head.next == null){
            return true;
        }
        ListNode n = head;
        int count = 0;//记录多少个数值
        Stack<Integer> stack = new Stack<>();
        while (n != null){
            stack.push(n.value);
            n = n.next;
            count++;
        }
        for (int i = 0; i <= count / 2; i++) {
            if (head.value != stack.peek()){
                return false;
            }else {
                head = head.next;
                stack.pop();
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(paliList(head));
    }
}
