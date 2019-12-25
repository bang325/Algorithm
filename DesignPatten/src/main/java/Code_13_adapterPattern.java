/**适配器模式--翻译的作用
 * @author Bang
 * @date 2019/12/25  11:10
 */
public class Code_13_adapterPattern {

    public static void main(String[] args) {
        Forwards forward = new Forwards("詹姆斯");
        forward.Attack();

        Guard guard = new Guard("科比");
        guard.Attack();

        Center center = new Center("霍华德");
        center.Defense();

        PlayerAdapter playerAdapter = new PlayerAdapter("姚明");
        playerAdapter.Attack();
    }
}
//抽象运动员类
abstract class Player{
    protected String name;
    public Player(String name){
        this.name = name;
    }
    public abstract void Attack();
    public abstract void Defense();
}
//前锋类
class Forwards extends Player{
    public Forwards(String name) {
        super(name);
    }

    @Override
    public void Attack() {
        System.out.println("前锋" + name + "进攻");
    }

    @Override
    public void Defense() {
        System.out.println("前锋 " + name + "防守");
    }
}

//中锋类
class  Center extends Player{
    public Center(String name) {
        super(name);
    }

    @Override
    public void Attack() {
        System.out.println("中锋" + name + "进攻");
    }

    @Override
    public void Defense() {
        System.out.println("中锋" + name + "进攻");
    }
}

class  Guard extends Player{
    public Guard(String name) {
        super(name);
    }

    @Override
    public void Attack() {
        System.out.println("后锋" + name + "进攻");
    }

    @Override
    public void Defense() {
        System.out.println("后锋" + name + "进攻");
    }
}

class ForeignCenter {
    private String name;
    public  ForeignCenter(String name){
        this.name = name;
    }

    public void jingong(){
        System.out.println("外籍中锋 " + name + " 进攻");
    }
    public void fangshou(){
        System.out.println("外籍中锋 " + name + " 防守");
    }
}

//适配器类
class PlayerAdapter extends  Player{
    ForeignCenter FC = null;
    public PlayerAdapter(String name) {
        super(name);
        FC = new ForeignCenter(name);
    }

    @Override
    public void Attack() {
        FC.jingong();
    }

    @Override
    public void Defense() {
        FC.fangshou();
    }
}

