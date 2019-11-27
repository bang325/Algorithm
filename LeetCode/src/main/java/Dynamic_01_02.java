/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），
 * 设计一个算法来计算你所能获取的最大利润。
 * 注意你不能在买入股票前卖出股票。
 * @author Bang
 * @date 2019/8/30  9:37
 */
public class Dynamic_01_02 {
    public static int stock(int[] arr){
        if (arr.length == 1){
            return -1;
        }
        int money = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] - arr[i] > money){
                    money = arr[j] - arr[i];
                }
            }
        }
        return money;
    }
    public static int stock1(int[] arr){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min){
                min = arr[i];
            }else if (arr[i] - min > max){
                max = arr[i] - min;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        System.out.println(stock(arr));
        System.out.println(stock1(arr));
    }
}
