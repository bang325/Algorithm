/**
 * 前缀树
 * 如何生成前缀树？
 * 例子： 一个字符串类型的数组arr1，另一个字符串类型的数组arr2
 *
 * arr2中有哪些字符，是arr1中出现的？请打印
 *
 * arr2中有哪些字符，是作为arr1中某个字符串前缀出现的？请 打印
 *
 * arr2中有哪些字符，是作为arr1中某个字符串前缀出现的？
 * 请打印 arr2中出现次数最大的前缀。
 * @author Bang
 * @date 2019/8/14  13:00
 */
public class Code_01_TrieTree {
    public static class TrieNode {
        public int path;
        public int end;
        public TrieNode[] next;

        public TrieNode() {
            path = 0;
            end = 0;
            next = new TrieNode[26];
        }
    }

    //生成前缀树
    public static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        //插入一个字符串
        public void insert(String word) {
            if (word == null) {
                return;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';//ascii
                if (node.next[index] == null) {
                    node.next[index] = new TrieNode();
                }
                node = node.next[index];
                node.path++;
            }
            node.end++;
        }

        //删掉一个值
        public void delete(String word) {
            if (word == null) {
                return;
            }
            if (search(word) != 0) {
                char[] chars = word.toCharArray();
                TrieNode node = root;
                int index = 0;
                for (int i = 0; i < chars.length; i++) {
                    index = chars[i] - 'a';
                    if (--node.next[index].path == 0) {
                        node.next[index] = null;
                        return;
                    }
                    node = node.next[index];
                }
                node.end--;
            }
        }

        //字符串插入的次数
        public int search(String word) {
            if (word == null) {
                return 0;
            }
            char[] chars = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if (node.next[index] == null) {
                    return 0;
                }
                node = node.next[index];
            }
            return node.end;
        }

        //字符串为前缀出现最大次数
        public int preFixNum(String pre){
            if (pre == null){
                return 0;
            }
            char[] chars = pre.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if (node.next[index] == null){
                    return 0;
                }
                node = node.next[index];
            }
            return node.path;
        }
    }
    public static void main(String[] args) {
        Trie trie = new Trie();
        System.out.println(trie.search("zuo"));
        trie.insert("zuo");
        System.out.println(trie.search("zuo"));
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.insert("zuo");
        trie.insert("zuo");
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.delete("zuo");
        System.out.println(trie.search("zuo"));
        trie.insert("zuoa");
        trie.insert("zuoac");
        trie.insert("zuoab");
        trie.insert("zuoad");
        trie.delete("zuoa");
        System.out.println(trie.search("zuoa"));
        System.out.println(trie.preFixNum("zuo"));

    }
}
