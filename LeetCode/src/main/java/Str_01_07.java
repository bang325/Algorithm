/**
 * 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，
 * 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
 * 如果不存在，则返回  -1。
 * 示例 1:
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * @author Bang
 * @date 2019/8/27  16:39
 */
public class Str_01_07 {
    public static int needle(String str1 , String str2){
        if (str1.length() < str2.length()){
            return -1;
        }
        if (str2.length() == 0) {
            return 0;
        }
        for (int i = 0; i < str1.length() - str2.length() + 1; i++){
            if (str1.substring(i,i+str2.length()).equals(str2)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String str1 = "hoolle";
        String str2 = "ll";
        System.out.println(needle(str1,str2));
    }
}
