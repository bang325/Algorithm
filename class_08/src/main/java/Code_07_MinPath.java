/**
 * 给你一个二维数组，二维数组中的每个数都是正数，
 * 要求从左上 角走到右下角，每一步只能向右或者向下。
 * 沿途经过的数字要累 加起来。返回最小的路径和。
 *
 * @author Bang
 * @date 2019/8/15  9:52
 */
public class Code_07_MinPath {
    public static int minPath(int[][] m){

        return process(m,0,0);
    }

    //从i，j点到右下角
    private static int process(int[][] m, int i, int j) {
        if (i == m.length-1 && j == m[0].length-1){
            //如果是最后一个数，到达最后一个数自己，需要代价是自己
            return m[i][j];
        }
        if (i == m.length-1){
            //数字在最后一行，只能向右走
            return m[i][j] +process(m,i,j+1);
        }
        if (j == m[0].length-1){
            //数字在最后一列，只能向下走
            return m[i][j] +process(m,i+1,j);
        }
        //其他是正常情况，选择向下或者向右
        int right = process(m,i,j+1);//右
        int down =  process(m,i+1,j);//下
        return m[i][j] + Math.min(right,down);

    }

    public static void main(String[] args) {
        int[][] matrix = {  { 1, 3, 5, 9 },
                            { 8, 1, 3, 4 },
                            { 5, 0, 6, 1 },
                            { 8, 8, 4, 0 } };
        System.out.println(minPath(matrix));
    }
}
