import java.util.HashMap;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * @author Bang
 * @date 2019/8/30  14:46
 */
public class Other_01_05 {
    public static boolean isValid(String str){
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.length() % 2 != 0){
                return false;
            }
            char c = str.charAt(i);
            if (map.containsKey(c)){
                char top = stack.isEmpty() ? '#' : stack.pop();
                if (top != map.get(c)){
                    return false;
                }
            }else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str = "((())){{{}}}[[]]";
        String str1 = "({[}])";
        System.out.println(isValid(str));
        System.out.println(isValid(str1));
    }
}
