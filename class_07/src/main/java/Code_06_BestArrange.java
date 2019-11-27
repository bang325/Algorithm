import java.util.*;
//import java.util.Arrays;
//import java.util.Comparator;

/**
 * 一些项目要占用一个会议室宣讲，会议室不能同时容纳两个项目的宣讲。
 * 给你每一个项目开始的时间和结束的时间
 * (给你一个数 组，里面 是一个个具体的项目)，
 * 你来安排宣讲的日程，要求会 议室进行 的宣讲的场次最多。
 * 返回这个最多的宣讲场次。
 *
 * 思路：利用项目的结束时间，将结束时间以升序方式排序，
 *       选择最早结束的项目，再将与之冲突的项目删去，
 *       寻找下一最早结束的项目，直到找出最后的项目，同时所有项目被删除
 * @author Bang
 * @date 2019/8/14  15:14
 */
public class Code_06_BestArrange {
    public static class Node{
        public int start;
        public int end;

        public Node(int start,int end){
            this.start = start;
            this.end = end;
        }
    }
    //自己构建比较器
    public static class ProgramComparator implements Comparator<Node>{
        @Override
        public int compare(Node o1, Node o2) {
            return o1.end - o2.end;//将结束时间以升序方式排序
        }
    }

    public static int bestArrange(Node[] programs,int cur){
        Arrays.sort(programs,new ProgramComparator());
        int res = 0;
        for (int i = 0; i < programs.length; i++) {
            if (cur <= programs[i].start){
                res++;
                cur = programs[i].end;
            }
        }
        return res;
    }
}
