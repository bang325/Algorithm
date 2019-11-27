import java.util.HashMap;

/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * @author Bang
 * @date 2019/8/26  16:12
 */
public class Array_01_10 {
    public static boolean isValid(char[][] arr){
        HashMap<Integer,Integer>[] rows = new HashMap[9];
        HashMap<Integer,Integer>[] cloumns = new HashMap[9];
        HashMap<Integer,Integer>[] boxes = new HashMap[9];
        for (int i = 0; i < arr.length; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            cloumns[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                char num = arr[i][j];
                if (num != '.'){
                    int n = (int)num;
                    int boxesId = (i/3)*3 + j/3;

                    rows[i].put(n,rows[i].getOrDefault(n,0)+1);
                    //getOrDefault当Map集合中有这个key时，就使用这个key值，如果没有就使用默认值
                    cloumns[j].put(n,cloumns[j].getOrDefault(n,0)+1);
                    boxes[boxesId].put(n,boxes[boxesId].getOrDefault(n,0)+1);

                    if (rows[i].get(n) > 1 ||cloumns[j].get(n) > 1 || boxes[boxesId].get(n) > 1){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] arr = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(isValid(arr));
    }
}
