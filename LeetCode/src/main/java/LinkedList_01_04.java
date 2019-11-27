/**
 * @author Bang
 * @date 2019/8/28  11:13
 */
public class LinkedList_01_04 {
    public static class ListNode{
        public int value;
        public ListNode next;
        public ListNode(int x){
            this.value = x;
        }
    }
    public static ListNode merge(ListNode node1,ListNode node2){
        ListNode res = null;
        if (node1 == null){
            return node2;
        }else if (node2 == null){
            return node1;
        }else if (node1.value <= node2.value){
            node1.next = merge(node1.next,node2);
            res = node1;
        }else if (node1.value > node2.value){
            node2.next = merge(node1,node2.next);
            res = node2;
        }
        return res;
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

        ListNode res0 = merge(head,head1);

        while (res0 != null){
            System.out.print(res0.value + "");
            res0 = res0.next;
        }

    }
}
