/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角
 * （在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 * @author Bang
 * @date 2019/8/30  11:00
 */
public class Dynamic_02_02 {
    public static int move(int m,int n){
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            arr[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            arr[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                arr[i][j] = arr[i][j-1] + arr[i-1][j];
            }
        }
        return arr[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(move(7,3));
    }
}
