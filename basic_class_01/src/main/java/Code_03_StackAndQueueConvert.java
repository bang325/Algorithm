import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 1.仅用队列结构实现栈结构
 * 2.仅用栈结构实现队列结构
 *
 * 思路：1 两个队列，一个队列将原始数据全部进入，
 * 出的时候留下最后一个数，输出
 * 继续该操作，每次出队列后留下最后一个数输出，则完成栈功能
 *
 * 思路：2 两个栈，一个栈进入数据，从栈一中拿出数据放入栈二中
 * 输出栈二数据，如果想继续添加数据，则数据进入栈一，但是要求
 * 栈一为空才能继续添加数据
 * 重复以上操作
 * @author Bang
 * @date 2019/8/9  14:17
 */
public class Code_03_StackAndQueueConvert {
    //仅用栈结构实现队列结构
    public static class TwoStacksQueue {
        private Stack<Integer> stackPush;
        private Stack<Integer> stackPop;

        public TwoStacksQueue() {
            stackPush = new Stack<Integer>();
            stackPop = new Stack<Integer>();
        }

        public void push(int pushInt){
            stackPush.push(pushInt);
        }
        public int poll(){
            if (stackPop.isEmpty() && stackPush.isEmpty()){
                throw new RuntimeException("队列为空");
            }else if (stackPop.isEmpty()){
                while (!stackPush.isEmpty()){
                    stackPop.push(stackPush.pop());//将数据栈的数据放入另一个站
                }
            }
            return stackPop.pop();
        }
        public int peek(){
            if (stackPop.isEmpty() && stackPush.isEmpty()){
                throw new RuntimeException("队列为空");
            }else if (stackPop.isEmpty()){
                while (!stackPush.isEmpty()){
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.peek();
        }
    }

    //仅用队列结构实现栈结构
    public static class TwoQueueStack{
        private Queue<Integer> queue;
        private Queue<Integer> help;

        public TwoQueueStack(){
            queue = new LinkedList<Integer>();
            help = new LinkedList<Integer>();
        }

        public void push(int pushInt){
            queue.add(pushInt);
        }
        //peek 拿到栈顶数字，不对数字进行操作
        public int peek(){
            if (queue.isEmpty()){
                throw new RuntimeException("栈为空");
            }
            //将最后一个数留下
            while (queue.size() != 1){
                help.add(queue.poll());
            }
            //最后一个数为res
            int res = queue.poll();
            help.add(res);
            swap();
            return res;
        }
        //pop 拿到栈顶数字,将栈顶元素弹出
        public int pop(){
            if (queue.isEmpty()){
                throw new RuntimeException("栈为空");
            }
            while (queue.size() > 1){
                help.add(queue.poll());
            }
            int res = queue.poll();
            swap();
            return res;
        }

        private void swap(){
            Queue<Integer> tmp = help;
            help = queue;
            queue = tmp;
        }
    }
}
