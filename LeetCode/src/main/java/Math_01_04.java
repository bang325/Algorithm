import java.util.HashMap;

/**
 * 罗马数字转整数
 * @author Bang
 * @date 2019/8/30  12:15
 */
public class Math_01_04 {
    public static int convert(String str){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I",1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
        int res = 0;
        for (int i = 0; i < str.length(); ) {
            if (i+1 < str.length() && map.containsKey(str.substring(i,i+2))){
                res += map.get(str.substring(i,i+2));
                i+=2;
            }else {
                res += map.get(str.substring(i,i+1));
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "MCMXCIV";
        System.out.println(convert(str));
    }
}
