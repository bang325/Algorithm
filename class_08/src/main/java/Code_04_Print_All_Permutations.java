import java.util.HashSet;

/**
 * 打印一个字符串的全部排列
 *解决问题思想:
 * 1.先把字符串的第一个字符串与它每一个字符交换：abc,bac,cba.
 * 2.在把得到的新字符串从第二位开始，依次与后面字符交换，以此类推。
 * 递归下去。
 *
 * 打印一个字符串的全部排列，要求不要出现重复的排列
 * 思路：与之前处理类似，区别在于，判断新加入的字符串是否已经出现过
 *      若出现过，不重复处理，使用hashset
 * @author Bang
 * @date 2019/8/14  21:34
 */
public class Code_04_Print_All_Permutations {
    public static void printAllPermutations(String str){
        char[] chars = str.toCharArray();
        process(chars,0);
    }

    private static void process(char[] chars, int i) {
        if (i == chars.length){
            System.out.println(String.valueOf(chars));
        }
        for (int j = i ; j < chars.length; j++) {
            swap(chars,i,j);
            process(chars,i+1);
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] =tmp;
    }

    public static void printAllPermutations2(String str) {
        char[] chs = str.toCharArray();
        process2(chs, 0);
    }

    private static void process2(char[] chs, int i) {
        if (i == chs.length){
            System.out.println(String.valueOf(chs));
        }
        HashSet<Character> set = new HashSet<>();
        for (int j = i; j < chs.length; j++) {
            if (!set.contains(chs[j])){
                set.add(chs[j]);
                swap(chs,i,j);
                process2(chs,i+1);
            }
        }
    }

    public static void main(String[] args) {
        String test1 = "abc";
        printAllPermutations(test1);
        System.out.println("===111111===");
        printAllPermutations2(test1);
        System.out.println("===22222222===");

        String test2 = "acc";
        printAllPermutations(test2);
        System.out.println("===33333333===");
        printAllPermutations2(test2);
        System.out.println("====444444444==");
    }
}
