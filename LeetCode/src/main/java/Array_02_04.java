import java.util.HashSet;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 思路：使用hashSet
 * 从左遍历到最右，右边字符加入结果字符串，存在相同时，移去左边字符，同时记录最大长度
 * @author Bang
 * @date 2019/8/27  10:10
 */
public class Array_02_04 {
    public static void longestStr(String str){
        HashSet<Character> set = new HashSet<>();
        StringBuffer resStr = new StringBuffer();
        int res = 0, l = 0 , r = 0;
        if (str.length() == 0 || str == null){
            return;
        }
        while (r < str.length()){
            if (!set.contains(str.charAt(r))){
                set.add(str.charAt(r++));
                res = Math.max(res,set.size());
            }else {
                set.remove(str.charAt(l++));
            }
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        String str = "pwwkew";
        longestStr(str);
    }
}
