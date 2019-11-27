import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定字符串拼接后最小的组合
 * 思路：小的拍的前面
 * @author Bang
 * @date 2019/8/14  12:09
 */
public class Code_05_LowestLexicography {
    public static class MyComparator implements Comparator<String>{
        @Override
        public int compare(String o1, String o2) {
            return (o1+o2).compareTo(o2+o1);
        }
    }
    public static String lowestString(String[] strs){
        if (strs == null || strs.length == 0){
            return "";
        }
        Arrays.sort(strs,new MyComparator());
        String res = "";
        for (int i = 0; i < strs.length; i++) {
            res += strs[i];
        }
        return res;
    }
    public static void main(String[] args) {
        String[] strs1 = { "jibc", "ji", "jp", "bw", "jibw" };
        System.out.println(lowestString(strs1));

        String[] strs2 = { "ba", "b" };
        System.out.println(lowestString(strs2));

    }
}
