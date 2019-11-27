/**
 * 给你一个数组arr，和一个整数aim。如果可以任意选择arr中的 数字，
 * 能不能累加得到aim，返回true或者false
 * 从0出发，每个数组中的数字加入或者不加入之前的和，最终数字存在aim值
 * 返回true
 * @author Bang
 * @date 2019/8/15  10:31
 */
public class Code_08_Arr_Sum_Aim {
    public static boolean arrSumAim(int[] arr,int i,int sum ,int aim){
        //sum已经形成的数和，aim要求形成的数
        if (i == arr.length){
            return aim == sum;
        }
        boolean a = arrSumAim(arr,i+1,sum,aim);//不要该数字
        boolean b = arrSumAim(arr,i+1,sum+arr[i],aim);//要该数字
        return a||b;
    }

    public static void main(String[] args) {
        int[] arr = {2,34,-3,2,2,2,3,4,5,4,6,7,8,5,};
        System.out.println(arrSumAim(arr,0,0,-1));
    }
}
