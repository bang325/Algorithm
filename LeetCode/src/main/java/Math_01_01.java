import java.util.ArrayList;
import java.util.List;

/**
 * @author Bang
 * @date 2019/8/30  11:50
 */
public class Math_01_01 {
    public static List<String> output(int n){
        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            boolean is3 = (i % 3 == 0);
            boolean is5 = (i % 5 == 0);
            if (is3 && is5){
                list.add("AB");
            }else if (is3){
                list.add("A");
            }else if (is5){
                list.add("B");
            }else {
                list.add(Integer.toString(i));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(output(20));
    }
}
