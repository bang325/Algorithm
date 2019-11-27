/**转圈打印矩阵 【题目】
 * 给定一个整型矩阵matrix，请按照转圈的方式打印它。
 * 例如： 1   2   3   4
 *        5   6   7   8
 *        9  10  11  12
 *        13 14  15  16
 *  打印结果为：1，2，3，4，8，12，16，15，14，13，9， 5，6，7，11， 10
 *
 *  思路：将矩阵看成框，先打印最外层框，再打印下一层，
 *  依次打印，直到打印完为止
 * @author Bang
 * @date 2019/8/12  15:19
 */
public class Code_06_PrintMatrixSpiralOrder {
    public static void spiralOrderPrint(int[][] matrix){
        int tR = 0;//左上角行
        int tC = 0;//左上角列
        int dR = matrix.length-1;//右下角行
        int dC = matrix[0].length-1;//右下角列
        while (tR < dR && tC <= dC){
            printEdge(matrix,tR++,tC++,dR--,dC--);
        }
    }

    private static void printEdge(int[][] matrix, int tR, int tC, int dR, int dC) {
        if (tR == dR){ //只有一行
            for (int i = tC; i <= dC ; i++) {
                System.out.println(matrix[tR][i] + " ");
            }
        }else if (tC == dC){//只有一列
            for (int i = tR; i <= dR ; i++) {
                System.out.println(matrix[i][tC] + " ");
            }
        }else {
            int curC = tC;
            int curR = tR;
            while (curC != dC){
                System.out.println(matrix[tR][curC] + " ");
                curC++;
            }
            while (curR != dR){
                System.out.println(matrix[curR][tC] + " ");
                curR++;
            }
            while (curC != tC){
                System.out.println(matrix[dR][curC] + "");
                curC--;
            }
            while (curR != tR){
                System.out.println(matrix[curR][dC] + " ");
                curR--;
            }
        }
    }
}
