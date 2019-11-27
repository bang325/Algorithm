/**打印两个有序链表的公共部分
 * 【题目】 给定两个有序链表的头指针head1和head2，
 * 打印两个 链表的公共部分。
 * @author Bang
 * @date 2019/8/12  17:41
 */
public class Code_10_PrintCommonPart {
    public static class Node {
        public int value;
        public Node next;
        public Node(int data){
            this.value = data;
        }
    }

    public static void printCommonPart(Node head1,Node head2){
        System.out.println("Common Part:");
        while (head1 != null && head2 != null){
            if (head1.value > head2.value){
                head2 = head2.next;
            }else if (head1.value < head2.value){
                head1 = head1.next;
            }else {
                System.out.println(head1.value + "");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        System.out.println();
    }

    public static void printLinkedList(Node node){
        System.out.println("Linked List: " );
        while (node != null){
            System.out.println(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node node1 = new Node(2);
        node1.next = new Node(3);
        node1.next.next = new Node(5);
        node1.next.next.next = new Node(8);

        Node node2 = new Node(1);
        node2.next = new Node(3);
        node2.next.next = new Node(5);
        node2.next.next.next = new Node(7);
        node2.next.next.next.next = new Node(8);

        printLinkedList(node1);
        printLinkedList(node2);
        printCommonPart(node1,node2);
    }
}
