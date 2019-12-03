/**外观模式
 * @author Bang
 * @date 2019/12/3  16:32
 */
public class Code_8_FacadePattern {
    public static void main(String[] args) {
        Fund jijin = new Fund();
        jijin.BuyFund();
        jijin.SellFund();
    }
}
class Stock{
    public void Sell(){
        System.out.println("卖出股票");
    }
    public void Buy(){
        System.out.println("买入股票");
    }
}

class NationalDebt{
    public void Sell(){
        System.out.println("卖出国债");
    }
    public void Buy(){
        System.out.println("买入国债");
    }
}
class Realty{
    public void Sell(){
        System.out.println("卖出房地产");
    }
    public void Buy(){
        System.out.println("买入房地产");
    }
}
class Fund{
    Stock p1;
    NationalDebt p2;
    Realty p3;
    public Fund(){
        p1 = new Stock();
        p2 = new NationalDebt();
        p3 = new Realty();
    }
    public void BuyFund(){
        p1.Buy();
        p2.Buy();
        p3.Buy();
    }
    public void SellFund(){
        p1.Sell();
        p2.Sell();
        p3.Sell();
    }
}