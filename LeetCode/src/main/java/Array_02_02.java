import java.util.Arrays;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0，
 * 则将其所在行和列的所有元素都设为 0。请使用原地算法
 *
 * 将0所在的行列换成其他数a,遍历完所有数字
 * 再将a换成0
 * @author Bang
 * @date 2019/8/26  18:43
 */
public class Array_02_02 {
    public static int[][] zero(int[][] arr){
        int a = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0){
                    for (int k = 0; k < arr.length; k++) {
                        if (arr[k][j] != 0){
                            arr[k][j] = a;
                        }
                    }
                    for (int k = 0; k < arr[0].length; k++) {
                        if (arr[i][k] != 0){
                            arr[i][k] = a;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == a){
                    arr[i][j] = 0;
                }
            }
        }
        return arr;
    }

    public static void print(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] arr = {
                {1,1,1,1},
                {1,1,0,0},
                {1,1,0,1},
                {1,0,1,1}
        };
        print(zero(arr));
    }
}
