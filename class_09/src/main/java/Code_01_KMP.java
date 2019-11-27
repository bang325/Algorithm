/**
 * KMP算法
 * 在一个文本串S内查找一个模式串P 的出现位置
 * @author Bang
 * @date 2019/8/22  13:36
 */
public class Code_01_KMP {
    public static int getIndexOf(String s,String m){
        if (s == null || m == null || s.length() < 1 || s.length() < m.length()){
            return -1;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = m.toCharArray();
        int i1 = 0;
        int i2 = 0;
        int[] next = getNextArray(str2);//拿到str2的回文数字下标
        while (i1 < str1.length && i2 < str2.length){
            if (str1[i1] == str2[i2]){//如果字符相等，则继续往前匹配
                i1++;
                i2++;
            }else if (next[i2] == -1){
                //如果不相等，且当前字符已经没有最长前缀和最长后缀的匹配
                i1++;//顺序匹配下一个字符
            }else {
                i2 = next[i2];
                //存在最长前缀和最长后缀相等大于0的，则从最长前缀的下一个字符开始匹配，
                // 最长前缀那一部分不用匹配是因为 一定是相等的
            }
        }
        return i2 == str2.length ? i1-i2:-1;
        //如果跳出循环的是因为匹配到最后一个字符正确跳出的，则存在子串，否则不存在返回-1
    }

    private static int[] getNextArray(char[] str) {
        //每个字符前一个最长前缀和最长后缀信息（相等）
        // a,b,a,b,a,c
        //-1,0,0,1,2,3
        //前缀不能包含最后一个字符
        //后缀不能包含第一个字符
        if (str.length == 1){
            return new int[]{-1};
        }
        int[] next = new int[str.length];
        next[0] = -1;
        next[1] = 0;//前面这两个数是人为规定的
        int i = 2;//从匹配字符串得下标2处开始计算
        int cn = 0;
        //代表分界指标，这边有一个隐含的条件，最长前缀和最长后缀的长度==最长前缀的最后一个字符下标
        while (i<next.length){
            if (str[i-1] == str[cn]){//如果跳到得字符和cn处得字符相同，回文长度就是cn+1
                next[i++] = ++cn;
            }else if (cn > 0){
                cn = next[cn];
                //前一个字符和最长前缀的下一个字符不相等，则以最长前缀下一个字符为切分点继续切分
            }else {
                next[i++] = 0;
                //cn来到了没有最长前缀，则i这个位置的next值为0
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String str1 = "abcbatabcbaf";
        String str2 = "abcbaf";
        System.out.println(getIndexOf(str1,str2));
    }
}
