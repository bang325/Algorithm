import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 输入： 参数1，正数数组costs 参数2，正数数组profits
 *        参数3， 正数k 参数4，正数m
 * costs[i]表示i号项目的花费
 * profits[i]表示i号项目在扣除花费之后还能挣到的钱(利润)
 * k表示你不能并行、只能串行的最多做k个项目
 * m表示你初始的资金
 * 说明：你每做完一个项目，马上获得的收益，
 *      可以支持你去做下 一个项目，每个项目做一次。
 * 输出：你最后获得的最大钱数。
 *
 * 思路：花费C 形成小根堆
 *       利润P 形成大根堆
 *       小根堆中比W小的都拿出来，放进大根堆，输出大根堆的堆顶就是一次项目的最大利润
 *       循环K次，输出W和各个利润之和
 * @author Bang
 * @date 2019/8/14  14:02
 */
public class Code_03_IPO {
    public static class Node{
        public int p;//利润 profit
        public int c;//cost 花费

        public Node(int p,int c){
            this.p = p ;
            this.c = c;
        }
    }

    //构建比较器
    public static class MinCostComparator implements Comparator<Node>{
        @Override
        public int compare(Node o1, Node o2) {
            return o1.c - o2.c;//升序排列
        }
    }

    public static class MaxProfitComparator implements Comparator<Node>{
        @Override
        public int compare(Node o1, Node o2) {
            return o2.c - o1.c;//降序排列
        }
    }

    public static int findMax(int k,int W,int[] profits,int[] costs){
        Node[] nodes = new Node[profits.length];
        for (int i = 0; i < profits.length; i++) {
            nodes[i] = new Node(profits[i],costs[i]);
        }

        PriorityQueue<Node> minCosts = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Node> maxProfits = new PriorityQueue<>(new MaxProfitComparator());

        for (int i = 0; i < nodes.length; i++) {
            minCosts.add(nodes[i]);
        }
        for (int i = 0; i < k; i++) {
            while (!minCosts.isEmpty() && minCosts.peek().c <= W){
                maxProfits.add(minCosts.poll());
            }
            if (maxProfits.isEmpty()){
                return W;
            }
            W += maxProfits.poll().c;
        }
        return W;
    }
}
