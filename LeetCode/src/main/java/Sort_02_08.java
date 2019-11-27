/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。
 * 该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * @author Bang
 * @date 2019/8/29  13:31
 */
public class Sort_02_08 {
    public static boolean Num(int[][] arr , int k){
        if (arr.length == 0 || arr[0].length == 0 ){
            return false;
        }
        int i = 0;
        int j = arr[0].length-1;
        while (i < arr.length && j > -1){
                if (arr[i][j] == k){
                    return true;
                }else if (arr[i][j] > k){
                    j--;
                }else if (arr[i][j] < k){
                    i++;
                }
            }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {
                        {1,   4,  7, 11, 15},
                        {2,   5,  8, 12, 19},
                        {3,   6,  9, 16, 22},
                        {10, 13, 14, 17, 24},
                        {18, 21, 23, 26, 30}
                        };
        System.out.println(Num(arr,25));
        System.out.println(Num(arr,23));
    }
}
