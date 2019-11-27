/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * @author Bang
 * @date 2019/8/27  16:58
 */
public class Str_01_09 {
    public static String same(String[] strs){
        if (strs.length == 0){
            return "";
        }
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(res) != 0){
                res = res.substring(0,res.length()-1);
                if (res.isEmpty()){
                    return "";
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(same(strs));
    }
}
