/**“之”字形打印矩阵
 * 【题目】 给定一个矩阵matrix，按照“之”字形的方式打印这 个矩阵，
 * 例如： 1   2   3   4
 *        5   6   7   8
 *        9  10  11  12
 * “之”字形打印结果为：
 * 1，2，5，9，6，3，4，7，10，11， 8，12
 * 思路：AB两个点从左上方开始同时进行，
 * A每次向右前进一位，直到行尾时开始向下前进
 * B每次向下前进一位，直到列尾时开始向右前进
 * 标记一个bool变量，记录是从A——》B  还是B——》A
 * 最后打印出来
 * @author Bang
 * @date 2019/8/12  16:13
 */
public class Code_08_ZigZagPrintMatrix {
    public static void printMatrixZigZag(int[][] matrix){
        int AR = 0;//A点的行
        int AC = 0; //A点的列
        int BR = 0;//B点的行
        int BC = 0; //B点的列
        int endR = matrix.length-1;//行尾
        int endC = matrix[0].length-1;//列尾
        boolean fromUp = false;
        while (AR <= endR){
            printLevel(matrix,AR,AC,BR,BC,fromUp);
            AR = AC == endC ? AR + 1 :AR;
            AC = AC == endC ? AC : AC + 1;
            BR = BR == endR ? BR : BR + 1;
            BC = BR == endR ? BC + 1 : BC;
            fromUp = !fromUp;
        }
    }

    private static void printLevel(int[][] matrix, int ar, int ac, int br, int bc, boolean fromUp) {
        if (fromUp){
            while (ar != br +1){
                //从A打印到B
                System.out.println(matrix[ar++][ac--] + " ");
            }
        }else {
            while (br != ar -1){
                //从B打印到A
                System.out.println(matrix[br--][bc++] + " ");
            }
        }
    }
}
