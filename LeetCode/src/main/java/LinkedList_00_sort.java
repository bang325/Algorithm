/**
 * 如果一个单链表为2->1->3->5->4，经过排序后链表结构为1->2->3->4->5，
 * 如果只改变链表节点的值，排序无效，需要改变每个节点的引用关系。
 * 思路如下：
 * 1  定义一个辅助节点aux，永远指向链表头结点，即aux.next=head;
 * 2  定义当前节点cur和它的上一个节点pre，如果pre.next<=cur.next,
 *    那么pre节点和cur节点同时向后移动
 * 3  如果pre.next>cur.next，切断pre节点和cur节点的引用关系，
 *    pre.next=cur.next，把cur节点插入前面恰当位置
 * 4 定义节点 node1=aux和node2=aux.next，同时向后移动node1和node2，
 *   当出现cur.val<node2.val时，把cur插入node1和node2之间
 * 5 cur节点变为pre.next
 * @author Bang
 * @date 2019/11/13  10:16
 */
public class LinkedList_00_sort {
    public static class Node{
        public Node next;
        public int value;
        public Node(int data){
            this.value = data;
        }
    }
    public static Node sort(Node head) {
        if(head==null||head.next==null){
            return head;
        }

        Node pre=head;
        //当前待排序的节点
        Node cur=head.next;
        //辅助节点，永远指向头结点
        Node aux=new Node(0);
        aux.next=head;
        while (cur!=null){
            if(cur.value<pre.value){
                //先把cur节点从当前链表中删除，然后再把cur节点插入到合适位置
                pre.next=cur.next;
                //从前往后找到node2.val>cur.val,然后把cur节点插入到node1和node2之间
                Node node1= aux;
                Node node2=aux.next;
                while (cur.value>node2.value){
                    node1=node2;
                    node2=node2.next;
                }
                //把cur节点插入到node1和node2之间
                node1.next=cur;
                cur.next=node2;
                //cur节点向后移动一位
                cur=pre.next;

            }else {
                //向后移动
                pre=cur;
                cur=cur.next;
            }
        }
        return aux.next;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(5);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(4);
        sort(head);
        while (head != null){
            System.out.print(head.value + " ");
            head = head.next;
        }
    }
}
