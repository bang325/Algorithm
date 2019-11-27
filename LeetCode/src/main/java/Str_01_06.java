/**
 * @author Bang
 * @date 2019/8/27  16:15
 */
public class Str_01_06 {
    public static int aoti(String str){
        //字符串不为空时并且字符串不全是空白字符串时才转换
        //去除掉前后的空格
        String str1 = str.trim();
        //存储最终过滤出来的字符串
        String resStr = null;
        //字符串不为空时并且字符串不全是空白字符串时才转换
        if (str1 != null || str1.isEmpty() == false){
            char first = str1.charAt(0);
            if (first >= '0' && first <= '9' || first == '+' || first == '-'){
                resStr = str1.substring(0,1);
                // 把第一位放进去(只能是数字、正负号)
                //这时候循环只要数字，因为正负号只能出现在第一位
                for (int i = 1; i < str1.length(); i++) {
                    if (str1.charAt(i) >= '0' && str1.charAt(i) <= '9'){
                        resStr = str1.substring(0,i+1);
                    }else {
                        //这是遇到不符合要求的字符，直接忽略剩余元素
                        break;
                    }
                }
            }
        }
        //判断最终字符串是否为空或则只有一个正负号
        if (resStr == null || resStr.equals("+") || resStr.equals("-")){
            //此时strrr是String对象，如果使用==比较则比较的时内存地址
            return 0;
        }
        //最终转换成的数字
        int resNum = 0;
        //使用异常机制打印结果
        try {
            resNum = Integer.parseInt(resStr);
        }catch (Exception e){
            if (resStr.charAt(0) == '-'){
                return Integer.MIN_VALUE;
            }else {
                return Integer.MAX_VALUE;
            }
        }
        return resNum;
    }

    public static void main(String[] args) {
        String str = "-91283472332";
        String str1 = "4193 with words";
        System.out.println(aoti(str));
        System.out.println(aoti(str1));
    }
}
