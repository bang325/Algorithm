/**
 * 用数组结构实现大小固定的队列
 * @author Bang
 * @date 2019/8/9  11:10
 */
public class ArrayToQueue {
    public static class ArraytoQueue{
        private Integer[] arr;
        private Integer first;
        private Integer end;
        private Integer size;

        public ArraytoQueue(int initsize){
            if (initsize < 0){
                throw new IllegalArgumentException("数字不能小于0");
            }
            arr = new Integer[initsize];
            first = 0;
            end = 0;
            size = 0;
        }

        public Integer peek(){
            if (size == 0){
                return null;
            }
            return arr[first];
        }
        public  void push(int obj){
            if (size == arr.length){
                throw new ArrayIndexOutOfBoundsException("队已满");
            }
            size++;
            arr[end] = obj;
            end = end == arr.length-1 ? 0:end+1;
        }
        public Integer poll(){
            if (size == 0){
                throw new IndexOutOfBoundsException("队空");
            }
            size--;
            int tmp = first;
            first = first == arr.length-1 ? 0 : first+1;
            return arr[tmp];
        }
    }
}
