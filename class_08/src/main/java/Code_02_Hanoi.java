/**
 * 汉诺塔问题
 * 打印n层汉诺塔从最左边移动到最右边的全部过程
 * @author Bang
 * @date 2019/8/14  17:01
 */
public class Code_02_Hanoi {
    public static void hanoi(int n){
        if (n > 0){
            func(n,"左","右","中");
        }
    }

    private static void func(int n, String from, String to, String help) {
        if (n == 1){
            System.out.println("move 1 from "+ from + " to " + to);
        }else {
            func(n-1,from,help,to);//把n-1挪到help上去，可借助的是to
            //func(1,from,to,help);
            System.out.println("move " + n +" from "+ from + " to " + to);
            func(n-1,help,to,from);//把n-1挪到to上去，可借助的是from
        }
    }

    public static void main(String[] args) {
        int n = 3;
        hanoi(n);
        //func(3,"左","右","中");

    }
}
