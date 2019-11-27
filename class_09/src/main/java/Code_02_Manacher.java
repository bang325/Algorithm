/**
 * 求个字符串中的回文串
 * 1、回文串的个数是可奇可偶的，碰上奇数的回文串还可以，
 * 如果是偶数的回文串没有着脚点，那就很恼人了。
 * 所以马拉车算法会对字符串进行预先处理，然后再求最长的回文串。
 * 首先用字符串中没有出现过的字符来表示串中每个元素的间隔，
 * 而为了防止在访问时出现越界情况，需要在串首和串尾再加上额外的特殊字符。
 * 例如：原串为ababab；处理完之后就是#a#b#a#b#a#b#
 * 其实对于最后一个$，也可以不加，因为字符串的最后一个字符是‘\0’
 * 就相当于一个特殊字符了。
 *
 * 接下来就是在新串中找以每一个字符为中心的回文串就可以了。
 * manacher算法的思想就是从左到右求出以每个字符为中心的最长回文串。
 * 设能延伸到最右边的字符串的中心位置为id，
 * 该字符串最右端的位置为mx，pal数组来储存此处回文串的长度。
 * 因为回文串有对称的性质，
 * 所以后边的字符串可以通过对称来直接求得其长度
 * （当然前边的还是需要乖乖的遍历求出来的）
 *
 * 3、对于遍历到的字符（下标设为i），一共会有三种情况；
 * (1)
 * i<=mx;
 * 直接把2*id-i处串的长度，复制给i就OK
 * (2)
 * i<=mx
 * 最右端超出了mx的范围，出现什么情况就不好说了，
 * 所以只能暴力一下，然后更新mx的大小
 * （3）
 * i>mx
 * 这种情况直接暴力，求此处回文串的长度即可
 *
 * 其中第7行是确定加速信息：如果当前遍历字符在R右边，
 * 先算上其本身有pArr[i]=1，后面检查如果能扩再直接pArr[i]++即可；
 * 否则，当前字符的pArr[i]要么是pArr[i']
 * （i关于C对称的下标i'的推导公式为2*C-i），
 * 要么是R-i+1，要么是>=R-i+1，
 * 可以先将pArr[i]的值置为这三种情况中最小的那一个，
 * 后面再检查如果能扩再直接pArr[i]++即可。
 * 最后得到的max是处理之后的串（length=2N+1）
 * 的最长回文子串的半径，max-1刚好为原串中最长回文子串的长度。
 * @author Bang
 * @date 2019/8/23  10:07
 */
public class Code_02_Manacher {
    //1 生成字符串
    public static char[] manacherString(String str){
        char[] source = str.toCharArray();
        char[] chs = new char[source.length * 2 + 1];
        for (int i = 0; i < chs.length; i++) {
            chs[i] = i%2 == 0 ? '#':source[i/2];
        }
        return chs;
    }
    public static int maxPalindromeLen(String str){
        char[] charArr = manacherString(str);
        int pArr[] = new int[charArr.length];
        int R = -1 ,C = -1;//c为最大回文串对应的中心点，right为该回文串能达到的最右端的值
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < charArr.length; i++) {
            pArr[i] = i>R? 1:Math.min(pArr[C*2-i],R-i);//min讨论的是i在C的右侧，取值
            while(i + pArr[i] < charArr.length && i - pArr[i] > -1){
                //无论是否能向右扩，均扩一下
                if (charArr[i + pArr[i]] == charArr[i - pArr[i]]){
                    pArr[i]++;
                }else {
                    break;
                }
            }
            if (R < i + pArr[i]){//如果扩出来的区域超过R，有一个新的回文右边界
                R = i + pArr[i] - 1;
                C = i;
            }
            max = Math.max(max,pArr[i]);
        }
        return max -1;
    }

    public static void main(String[] args) {
        System.out.println(maxPalindromeLen("cccabbacdd"));
    }
}
