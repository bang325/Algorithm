import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * @author Bang
 * @date 2019/8/30  14:33
 */
public class Other_01_04 {
    public static List<List<Integer>> yang(int n){
        ArrayList<List<Integer>> list = new ArrayList<>();
        if (n == 0){
            return list;
        }
        list.add(new ArrayList<>());
        list.get(0).add(1);
        for (int i = 1; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> pre = list.get(i-1);
            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(pre.get(j-1) + pre.get(j));
            }
            row.add(1);
            list.add(row);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(yang(5));
    }
}
