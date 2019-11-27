import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 * 思路：我们以某种方式将单词全部按照升序排列，
 * * 这样字母异位词就会变成相同的单词，
 * * 这时候我们只要将相同的单词记录到一组不就可以了么？
 * * 一个简单的map
 * * //HashMap + ArrayList，对字母异位词进行分组
 * *  //一个keyString对应一个ArrayList，归纳一组字母异位词
 * @author Bang
 * @date 2019/8/27  9:55
 */
public class Array_02_03 {
    public static ArrayList<List<String>> groups(String[] strs){
        if (strs.length == 0 || strs == null){
            return new ArrayList<List<String>>();
        }
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str:strs) {
            char[] chs = str.toCharArray();//转成字符数组
            Arrays.sort(chs);//对字符数组排序，可以分类字母异或位单词
            String keyStr = String.valueOf(chs);//将字符数组转为字符串
            if (!map.containsKey(keyStr)){
                //不包括该字符串，加入
                map.put(keyStr,new ArrayList<String>());
            }
            map.get(keyStr).add(str);//不管存在与否，都添加该字符串到对应数组

        }
        return new ArrayList<List<String>>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groups(strs));
    }
}
