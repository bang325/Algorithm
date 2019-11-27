import java.util.HashMap;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，
 * 并返回它的索引。如果不存在，则返回 -1。
 *
 * s = "leetcode"
 * 返回 0.
 * s = "loveleetcode",
 * 返回 2.
 * @author Bang
 * @date 2019/8/27  14:45
 */
public class Str_01_03 {
    public static int first(String str){
        if (str.length() <= 1){
            return 0;
        }
        int i = 0;
        for (int j = 1; j <str.length() && i<str.length() ; ) {
            if ((i == j) || str.charAt(i) != str.charAt(j) ) {
                j++;
                if ( j == str.length()){
                    return i;
                }
            }else {
                    i++;
                    j = 0;
            }
        }
        return -1;
    }

    public static int first1(String str){
        if (str.length() == 0){
            return -1;
        }
        if (str.length() == 1){
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String str = "leetcode";
        System.out.println(first(str));
        System.out.println(first1(str));
    }
}

