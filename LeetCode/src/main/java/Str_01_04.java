import java.util.Arrays;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 * @author Bang
 * @date 2019/8/27  15:13
 */
public class Str_01_04 {
    public static boolean same(String str1,String str2){
        if (str1.length() != str2.length()){
            return false;
        }
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        Arrays.sort(chs1);
        System.out.println(Arrays.toString(chs1));
        Arrays.sort(chs2);
        System.out.println(Arrays.toString(chs2));
        for (int i = 0; i < chs1.length; ) {
            if (chs1[i] == chs2[i]){
                i++;
                if (i == chs1.length){
                    return true;
                }
            }else {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str1 = "asdfg";
        String str2 = "sadfg";
        System.out.println(same(str1,str2));
    }
}
