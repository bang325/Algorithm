/**代理模式
 * @author Bang
 * @date 2019/11/29  11:21
 */
public class Code_4_proxyPattern {
    public static void main(String[] args) {
        SchoolGirl girl = new SchoolGirl();
        girl.setName("娇娇");
        Pursuit pursuit = new Pursuit(girl);
        Proxy proxy = new Proxy(girl);
        proxy.GiveDolls();
        proxy.GiveFlowers();
        proxy.GiveChocolate();
    }
}

//代理接口
interface IGiveGift{
    void GiveDolls();
    void GiveFlowers();
    void GiveChocolate();
}
//被追求者类
class SchoolGirl{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

//追求者类
class Pursuit implements IGiveGift{
    Pursuit ps;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    SchoolGirl mm;
    public Pursuit(SchoolGirl mm){
        this.mm = mm;
    }

    @Override
    public void GiveDolls() {
        System.out.println(mm.getName() +" 送你洋娃娃");
    }

    @Override
    public void GiveFlowers() {
        System.out.println(mm.getName() + " 送你鲜花");
    }

    @Override
    public void GiveChocolate() {
        System.out.println(mm.getName() + " 送你巧克力");
    }
}

class Proxy implements IGiveGift{
    Pursuit gg;
    public Proxy(SchoolGirl mm){
        gg = new Pursuit(mm);
    }

    @Override
    public void GiveDolls() {
        gg.GiveDolls();
    }

    @Override
    public void GiveFlowers() {
        gg.GiveFlowers();
    }

    @Override
    public void GiveChocolate() {
        gg.GiveChocolate();
    }
}