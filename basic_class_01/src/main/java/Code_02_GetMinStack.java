import java.util.Stack;

/**
 * 实现一个特殊的栈，在实现栈的基本功能的基础上，
 * 再实现返 回栈中最小元素的操作。
 * 【要求】 1．pop、push、getMin操作的时间复杂度都是O(1)。
 * 2．设计的栈类型可以使用现成的栈结构
 *
 * 思路：两个栈，一个装数据，一个装最小数
 * @author Bang
 * @date 2019/8/9  13:32
 */
public class Code_02_GetMinStack {
    public static class MyStack{
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack(){
            stackData = new Stack<Integer>();
            stackMin = new Stack<Integer>();
        }

        public void push(int newNum){
            if (stackMin.isEmpty()){
                stackMin.push(newNum);
            }else if (newNum < stackMin.peek()){
                stackMin.push(newNum);
            }else {
                int newMin = stackMin.peek();
                stackMin.push(newMin);
            }
            stackData.push(newNum);
        }
        public int pop(){
            if (stackMin.isEmpty()){
                throw new RuntimeException("栈空");
            }
            stackMin.pop();
            return stackData.pop();
        }
        public int getmin() {
            if (stackMin.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            return stackMin.peek();
        }

    }
    public static void main(String[] args) {

        MyStack stack2 = new MyStack();
        stack2.push(3);
        System.out.println(stack2.getmin());
        stack2.push(4);
        System.out.println(stack2.getmin());
        stack2.push(1);
        stack2.push(0);
        System.out.println(stack2.getmin());
        System.out.println(stack2.pop());
        System.out.println(stack2.getmin());
        System.out.println(stack2.pop());
    }

}
