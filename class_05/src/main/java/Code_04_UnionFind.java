import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.HashMap;
import java.util.List;

/**认识并查集结构
 * 解决问题：快速检查两个元素是否属于同一集合
 *           两个元素各自集合，合并在一起
 * @author Bang
 * @date 2019/8/14  9:22
 */
public class Code_04_UnionFind {
    public static class Node{

    }
    public static class UnionFindSet{
        public HashMap<Node, Node> fatherMap;//K是子，V是父
        public HashMap<Node, Integer> sizeMap;//某一个节点 他所在的集合有多少个节点

        public UnionFindSet(){
            fatherMap = new HashMap<Node, Node>();
            sizeMap = new HashMap<Node, Integer>();
        }
        //初始化
        public void makeSets(List<Node> nodes){
            fatherMap.clear();
            sizeMap.clear();
            for (Node node:nodes) {
                fatherMap.put(node,node);
                sizeMap.put(node,1);
            }
        }

        //找到头节点，一个集合的父
        public Node findHead(Node node){
            Node father = fatherMap.get(node);
            if (father != node){
                father = findHead(father);//递归找父
            }
            //找到的总父作为返回值，并将总父下面的节点全部挂在总父下
            fatherMap.put(node,father);
            return father;
        }
        //判断是否属于同一集合，直接判断节点的总父是否一致即可
        public boolean isSameSet(Node a,Node b){
            return findHead(a) == findHead(b);
        }

        //合并集合
        public void union(Node a,Node b){
            if (a == null || b == null){
                return;
            }
            Node aHead = findHead(a);
            Node bHead = findHead(b);
            if (aHead != bHead){
                int aSetSize = sizeMap.get(aHead);
                //aHead集合的节点数，头节点记录该集合有多少个节点数
                int bSetSize = sizeMap.get(bHead);
                //bHead集合的节点数
                if (aSetSize <= bSetSize){
                    //短的向长靠拢
                    fatherMap.put(aHead,bHead);//a-->b
                    sizeMap.put(bHead,aSetSize+bSetSize);//b的总节点数增加
                }else {
                    fatherMap.put(bHead,aHead);
                    sizeMap.put(aHead,aSetSize+bSetSize);
                }
            }
        }
    }
}
