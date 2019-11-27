import java.util.LinkedList;
import java.util.Queue;

/**介绍二叉树的序列化和反序列化
 * @author Bang
 * @date 2019/8/13  14:12
 */
public class Code_04_SerializeAndReconstructTree {
    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int data){
            this.value = data;
        }
    }
    //先序序列化
    public static String serialByPre(Node head){
        if (head == null){
            return "#_";
        }
        String str = head.value + "_";
        str += serialByPre(head.left);
        str += serialByPre(head.right);
        return str;
    }
    //反序列化
    public static Node reconByPreString(String preStr){
        String[] values = preStr.split("_");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i != values.length; i++) {
            queue.offer(values[i]);
        }
        return reconPreOrder(queue);
    }

    private static Node reconPreOrder(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")){
            return null;
        }
        Node head = new Node(Integer.valueOf(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }

    //按层序列化
    public static String serialByLevel(Node head){
        if (head == null){
            return "#_";
        }
        String res = head.value + "_";
        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);
        while (!queue.isEmpty()){
            head = queue.poll();
            if (head.left != null){
                res += head.left.value + "_";
                queue.offer(head.left);
            }
            if (head.right != null){
                res += head.right.value + "_";
                queue.offer(head.right);
            }else {
                res += "#_";
            }
        }
        return res;
    }

    //层次遍历反序列化
    public static Node reconByLevleString(String levelStr){
        String[] values = levelStr.split("_");
        int index = 0;
        Node head = generateNodeByString(values[index++]);
        Queue<Node> queue = new LinkedList<Node>();
        if (head != null){
            queue.offer(head);
        }
        Node node = null;
        while (!queue.isEmpty()){
            node = queue.poll();
            node.left = generateNodeByString(values[index++]);
            node.right = generateNodeByString(values[index++]);
            if (node.left != null){
                queue.offer(node.left);
            }
            if (node.right != null){
                queue.offer(node.right);
            }
        }
        return head;
    }

    private static Node generateNodeByString(String value) {
        if (value.equals("#")){
            return null;
        }
        return new Node(Integer.valueOf(value));
    }
}
