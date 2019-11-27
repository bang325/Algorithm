/**岛问题
 一个矩阵中只有0和1两种值，
 每个位置都可以和自己的上、下、左、右 四个位置相连，
 如果有一片1连在一起，这个部分叫做一个岛，
 求一个 矩阵中有多少个岛？
 举例：
             0 0 1 0 1 0
             1 1 1 0 1 0
             1 0 0 1 0 0
             0 0 0 0 0 0
 这个矩阵中有三个岛。
 * @author Bang
 * @date 2019/8/14  10:33
 */
public class Code_03_Islands {
    public static int countIslands(int[][] m){
        if (m == null || m[0] == null){
            return 0;
        }
        int row = m.length;//行
        int col = m[0].length;//列
        int res = 0;//结果
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (m[i][j] == 1){
                    res++;
                    infect(m,i,j,row,col);//递归修改四周为1的点
                }
            }
        }
        return res;
    }

    private static void infect(int[][] m, int i, int j, int row, int col) {
        if (i < 0 || i >= row || j < 0 || j >= col || m[i][j] != 1){
            return;
        }
        m[i][j] = 2;//修改该点值为2 ，并将四周的值及相连为1的值都改为2
        infect(m,i+1,j,row,col);//下
        infect(m,i-1,j,row,col);//上
        infect(m,i,j+1,row,col);//右
        infect(m,i,j-1,row,col);//左
    }
    public static void main(String[] args) {
        int[][] m1 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 1, 1, 1, 0, 1, 1, 1, 0 },
                        { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                        { 0, 1, 1, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                        { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
        System.out.println(countIslands(m1));

        int[][] m2 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 1, 1, 1, 1, 1, 1, 1, 0 },
                        { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                        { 0, 1, 1, 0, 0, 0, 1, 1, 0 },
                        { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                        { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
        System.out.println(countIslands(m2));

    }
}
