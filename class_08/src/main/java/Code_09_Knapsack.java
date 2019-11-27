/**
 * 给定两个数组w和v，两个数组长度相等，w[i]表示第i件商品的重量，
 * v[i]表示第i件商品的价值。再给定一个整数bag，'
 * 要求你挑选商品的重量加起来一定不能超 过bag，
 * 返回满足这个条件 下，你能获得的最大价值。
 * @author Bang
 * @date 2019/8/15  11:00
 */
public class Code_09_Knapsack {
    public static int MaxProfit(int[] w,int[] v ,int bag){
        return  process(w,v,0,0,bag);
    }

    private static int process(int[] w, int[] v, int i, int value, int bag) {
        //i 数组长度计数器
        //alreadyWeight，当前i下 已有重量和
        if (bag < 0){
            return 0;
        }
        if (i == w.length){
            //i超过最后一个数
            return value;
        }
        return Math.max(process(w,v,i+1,value,bag),
                process(w,v,i+1,value+v[i],bag-w[i]));
    }

    public static void main(String[] args) {
        int[] arr1 = {3,2,4,7,1,3,4};
        int[] arr2 = {5,6,3,19,11,15,1};
        int bag = 11;
        System.out.println(MaxProfit(arr1,arr2,bag));
    }
}
