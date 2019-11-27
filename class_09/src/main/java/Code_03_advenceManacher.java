/**
 * 给你一个字符串，要求添加尽可能少的字符使其成为一个回文字符串。
 * 思路：当R第一次到达串尾时，做R关于C的对称点L，将L之前的字符串逆序就是结果。
 * @author Bang
 * @date 2019/8/23  10:57
 */
public class Code_03_advenceManacher {
    //1 生成字符串
    public static char[] manacherString(String str){
        char[] source = str.toCharArray();
        char[] chs = new char[source.length * 2 + 1];
        for (int i = 0; i < chs.length; i++) {
            chs[i] = i%2 == 0 ? '#':source[i/2];
        }
        return chs;
    }
    public static String maxPalindromeLen(String str){
        if (str == null || str.length() == 0){
            return  null;
        }
        char[] charArr = manacherString(str);
        int pArr[] = new int[charArr.length];
        int R = -1 ,C = -1;//c为最大回文串对应的中心点，right为该回文串能达到的最右端的值
        int max = -1;
        for (int i = 0; i < charArr.length; i++) {
            pArr[i] = R>i? Math.min(pArr[C*2-i],R-i):1;//min讨论的是i在C的右侧，取值
            while(i + pArr[i] < charArr.length && i - pArr[i] > -1){
                //无论是否能向右扩，均扩一下
                if (charArr[i + pArr[i]] == charArr[i - pArr[i]]){
                    pArr[i]++;
                }else {
                    break;
                }
            }
            if (R < i + pArr[i]){//如果扩出来的区域超过R，有一个新的回文右边界
                R = i + pArr[i] ;
                C = i;
            }
            if (R == charArr.length){
                max = pArr[i];
                break;
            }

        }
        char[] res = new char[str.length()-max+1];
        for (int i = 0; i < res.length; i++) {
            res[res.length - 1 -i] = charArr[i * 2 +1];
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {

        System.out.println(maxPalindromeLen("abcd123321"));
    }
}
