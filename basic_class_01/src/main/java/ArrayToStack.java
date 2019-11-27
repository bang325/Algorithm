/**
 * 用数组结构实现大小固定的栈
 * @author Bang
 * @date 2019/8/9  11:10
 */
public class ArrayToStack {
    public static class ArraytoStack{
        private Integer[] arr;
        private Integer index;//索引

        public ArraytoStack(int initsize){
            if (initsize < 0){
                throw new IllegalArgumentException("The init size is less than 0");
            }
            arr = new Integer[initsize];
            index = 0;
        }
        public Integer peek(){
            if (index == 0){
                return null;
            }
            return arr[index-1];
        }
        public void push(int obj){
            if (index == arr.length){
                throw new ArrayIndexOutOfBoundsException("栈已满");
            }
            arr[index++] = obj;
        }
        public Integer pop(){
            if (index == 0){
                throw new ArrayIndexOutOfBoundsException("栈已空");
            }
            return arr[--index];
        }

    }
}
