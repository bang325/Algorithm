/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * @author Bang
 * @date 2019/8/27  15:25
 */
public class Str_01_05 {
    public static boolean isPali(String str){
        if (str == null){
            return false;
        }
        if (str.length() == 1){
            return true;
        }
        int l = 0, r = str.length()-1;
        while (l < r){
            while (l < r && !Character.isLetterOrDigit(str.charAt(l))){
                //如果字符是字母或数字此方法返回true，否则为false。
                l++;
            }
            while (l < r && !Character.isLetterOrDigit(str.charAt(r))){
                r--;
            }
            if (Character.toLowerCase(str.charAt(l)) != Character.toLowerCase(str.charAt(r))){
                return false;
            }else {
                l++;
                r--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        System.out.println(isPali(str));
    }
}
