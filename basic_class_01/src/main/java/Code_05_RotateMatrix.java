/**
 * 旋转正方形矩阵
 * 【题目】 给定一个整型正方形矩阵matrix，
 * 请把该矩阵调整成 顺时针旋转90度的样子
 * 思路：先将最外层旋转好，再旋转第二层，依次直到最后一层
 * @author Bang
 * @date 2019/8/12  15:43
 */
public class Code_05_RotateMatrix {
    public static void rotate(int[][] matrix){
        int tR = 0;//左上角行
        int tC = 0;//左上角列
        int dR = matrix.length-1;//右下角行
        int dC = matrix[0].length-1;//右下角列
        rotateEdge(matrix,tR++,tC++,dR--,dC--);
    }

    private static void rotateEdge(int[][] matrix, int tR, int tC, int dR, int dC) {
        int times = dC - tC;//每一次循环转动次数
        int tmp = 0;
        for (int i = 0; i < times; i++) {
            tmp = matrix[tR][tC+i];
            matrix[tR][tC+i] = matrix[dR-i][tC];
            matrix[dR-i][tC] = matrix[dR][dC-i];
            matrix[dR][dC-i] = matrix[tR+i][dC];
            matrix[tR+i][dC] = tmp;
        }
    }
    public static void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.println(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        printMatrix(matrix);
        rotate(matrix);
        System.out.println("=========");
        printMatrix(matrix);

    }
}
