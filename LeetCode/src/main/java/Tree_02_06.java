/**
 * 一个矩阵中只有0和1两种值，
 *  每个位置都可以和自己的上、下、左、右 四个位置相连，
 *  如果有一片1连在一起，这个部分叫做一个岛，
 *  求一个 矩阵中有多少个岛？
 *  举例：
 *              0 0 1 0 1 0
 *              1 1 1 0 1 0
 *              1 0 0 1 0 0
 *              0 0 0 0 0 0
 *  这个矩阵中有三个岛。
 * @author Bang
 * @date 2019/8/29  10:52
 */
public class Tree_02_06 {
    public static int island(int[][] arr){
        if (arr == null || arr[0] == null){
            return 0;
        }
        int row = arr.length;
        int col = arr[0].length;
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] == 1){
                    res++;
                    infect(arr,i,j,row,col);
                }
            }
        }
        return res;
    }

    private static void infect(int[][] arr, int i, int j, int row, int col) {
        if (i >= row || j >= col || i < 0 || j < 0 || arr[i][j] != 1){
            return;
        }
        arr[i][j] = 2;
        infect(arr,i,j-1,row,col);//左
        infect(arr,i,j+1,row,col);//右
        infect(arr,i-1,j,row,col);//上
        infect(arr,i+1,j,row,col);//下
    }

    public static void main(String[] args) {
        int[][] m1 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 1, 1, 1, 0, 1, 1, 1, 0 },
                        { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                        { 0, 1, 1, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                        { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 1 }, };
        System.out.println(island(m1));
    }
}
