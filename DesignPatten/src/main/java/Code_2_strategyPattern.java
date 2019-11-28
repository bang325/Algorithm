import java.util.Scanner;

/**策略模式
 * @author Bang
 * @date 2019/11/28  11:57
 */
public class Code_2_strategyPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("单价：");
        String price = sc.next();
        System.out.println("数量：");
        String number = sc.next();
        System.out.println("打折率：");
        String rang = sc.next();

        //获取实际打折率
        double[] rangArr = {0, 0.9f, 0.8f, 0.7f};
        double total = 0f;
        try {
            CashContext cash = new CashContext(rang);
            total = cash.getResult(Double.parseDouble(price)*Double.parseDouble(number));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("输入的单价或者数量不是整数或者不包含这种折扣");
            System.exit(0);
        }
        System.out.println("打折策略：" + rang + "  总计： " + total);

    }
}

abstract class CashSuper{
    public abstract double acceptCash(double money);
}
//正常收费
class CashNormal extends CashSuper{
    @Override
    public double acceptCash(double money){
        return money;
    }
}

//打折收费
class CashRebate extends CashSuper{
    private double moneyRebate = 1l;
    public CashRebate(double moneyRebate){
        this.moneyRebate = moneyRebate;
    }
    @Override
    public double acceptCash(double money){
        return money * moneyRebate;
    }
}

//满多少返利
class CashReturn extends CashSuper{
    private double moneyCondition = 0.0f;
    private double moneyReturn = 0.0f;
    public CashReturn(double moneyCondition,double moneyReturn){
        this.moneyCondition = moneyCondition;
        this.moneyReturn = moneyReturn;
    }

    @Override
    public double acceptCash(double money) {
        double result = money;
        if (money > moneyCondition){
            result = money - Math.floor(money/moneyCondition)*moneyReturn;
            //math.floor(x)返回小于参数x的最大整数,即对浮点数向下取整
        }
        return result;
    }
}

class CashContext{
    private CashSuper strage ;
    public CashContext(String rang){
        switch (rang){
            case "1":
                strage = new CashNormal();
                break;
            case "0.9":
                strage = new CashRebate(0.9f);
                break;
            case "0.7":
                strage = new CashRebate(0.7f);
                break;
            case "300-100":
                strage = new CashReturn(300,100);
                break;
            default:
                throw  new RuntimeException("不包含此种折扣");
        }
    }
    public double getResult(double money){
        return strage.acceptCash(money);
    }
}