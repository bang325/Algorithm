/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。
 * 你可以假设 s 的最大长度为 1000。
 * @author Bang
 * @date 2019/8/27  11:34
 */
public class Array_02_05 {
    public static String maxPali(String str){
        if (str.length() <= 1){
            return str;
        }
        int start = 0, end = 0;
        for (int i = 0; i < str.length(); i++) {
            int len1 = isPali(str,i,i);
            int len2 = isPali(str,i,i+1);
            int len = Math.max(len1,len2);
            if (len > end - start){
                start = i -(len-1)/2;
                end = i+len/2;
            }
        }
        return str.substring(start,end+1);
    }

    private static int isPali(String s,int left,int right){
        int l = left,r = right;
        while (l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        return r-l-1;
    }


    //马拉车
    public static char[] manaStr(String str){
        //生成字符串
        char[] source = str.toCharArray();
        char[] chs = new char[source.length*2+1];
        for (int i = 0; i < chs.length; i++) {
            chs[i] = i%2 == 0 ? '#': source[i/2];
        }
        return chs;
    }

    public static int ManaStr(String str){
        char[] charArr = manaStr(str);
        int[] pArr = new int[charArr.length];
        int R = -1 ,C = -1;
        //c为最大回文串对应的中心点，right为该回文串能达到的最右端的值
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < charArr.length; i++) {
            pArr[i] = i>R? 1:Math.min(pArr[C*2-i],R-i);
            //min讨论的是i在C的右侧，取值
            while(i + pArr[i] < charArr.length && i - pArr[i] > -1){
                //无论是否能向右扩，均扩一下
            if (charArr[i + pArr[i]] == charArr[i - pArr[i]]){
                pArr[i]++;
                }else {
                break;
                }

            }
            if (R < i+pArr[i]){
                //如果扩出来的区域超过R，有一个新的回文右边界
                R = i + pArr[i] - 1;
                C = i;
            }
            max = Math.max(max,pArr[i]);
        }
        return max-1;
    }
    public static void main(String[] args) {
        String str = "abccbb";
        System.out.println(maxPali(str));
        System.out.println(ManaStr(str));
    }
}
