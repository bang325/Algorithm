/**
 * 打印一个字符串的全部子序列，包括空字符串suo'y
 * 思路：传入空字符串，递归每一个节点，要或者不要都是该节点的子节点
 * 递归所有节点，输出所有叶节点
 * @author Bang
 * @date 2019/8/14  21:21
 */
public class Code_03_Print_All_Subsquences {
    public static void printAllSub(char[] str,int i,String res){
        if (i == str.length){
            System.out.println(res);
            return ;
        }
        printAllSub(str,i+1,res);//不要该节点
        printAllSub(str,i+1,res+str[i]);//要该节点

    }

    public static void main(String[] args) {
        String test = "abc";
        System.out.println("============");
        printAllSub(test.toCharArray(),0,"");
    }
}
