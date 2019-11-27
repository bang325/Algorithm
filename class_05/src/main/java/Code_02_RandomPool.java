import java.util.HashMap;

/**设计RandomPool结构
 * 【题目】 设计一种结构，在该结构中有如下三个功能：
 * insert(key)：将某个key加入到该结构，做到不重复加入。
 * delete(key)：将原本在结构中的某个key移除。
 * getRandom()： 等概率随机返回结构中的任何一个key。
 * 【要求】 Insert、delete和getRandom方法的时间复杂度都是 O(1)
 * 思路：利用两个哈希表，第一个加入K，对应V
 *                       第二个加入V，对应K
 *        增加和得到随机数是0（1）
 *        删除：每删除一个数，将最后一个数K值替换被删除数的K值
 *                              对应第二个哈希表中的K值也替换
 * @author Bang
 * @date 2019/8/13  19:10
 */
public class Code_02_RandomPool {
    //public static class Pool<K>  K代表泛型，不一定是String
    public static class Pool{
        public HashMap<String,Integer> keyIndexMap;
        public HashMap<Integer,String> indexKeyMap;
        public int size ;

        public Pool(){
            keyIndexMap = new HashMap<String,Integer>();
            indexKeyMap = new HashMap<Integer,String>();
            size = 0;
        }
        public void insert(String str){
            if (!keyIndexMap.containsKey(str)){
                keyIndexMap.put(str,size);
                indexKeyMap.put(size++,str);
            }
        }
        public void delete(String str){
            if (keyIndexMap.containsKey(str)){
                int deleteIndex = keyIndexMap.get(str);
                int lastIndex = --size;
                String lastStr = indexKeyMap.get(lastIndex);
                keyIndexMap.put(lastStr,deleteIndex);
                indexKeyMap.put(deleteIndex,lastStr);
                keyIndexMap.remove(str);
                indexKeyMap.remove(lastIndex);
            }
        }
        public String getRandom(){
            if (size == 0){
                return null;
            }
            int randomIndex = (int)(Math.random()*size);//0 ~ size -1
            return indexKeyMap.get(randomIndex);
        }
    }

    public static void main(String[] args) {
        Pool pool = new Pool();
        pool.insert("zuo");
        pool.insert("cheng");
        pool.insert("yun");
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());

    }
}
