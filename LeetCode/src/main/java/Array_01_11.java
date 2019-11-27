import java.util.Arrays;

/**
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 * @author Bang
 * @date 2019/8/26  16:32
 */
public class Array_01_11 {
    public static void rotate(int[][] arr){
        int tR = 0;
        int tC = 0;
        int dR = arr.length-1;
        int dC = arr.length-1;
        rotateEdge(arr,tR++,tC++,dR--,dC--);
    }

    private static void rotateEdge(int[][] arr, int tR, int tC, int dR, int dC) {
        int times = dC - tC;//每一次循环转动次数
        int tmp = 0;
        for (int i = 0; i < times; i++) {
            tmp = arr[tR][tC+i];
            arr[tR][tC+i] = arr[dR-i][tC];
            arr[dR-i][tC] = arr[dR][dC-i];
            arr[dR][dC-i] = arr[tR+i][dC];
            arr[tR+i][dC] = tmp;
        }
    }

    public static void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
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
