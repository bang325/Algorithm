import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**命令模式
 * @author Bang
 * @date 2020/1/8  9:53
 */
public class Code_19_orderPattern {
    public static void main(String[] args) {
        //开始前的准备
        Barbecuer barbecuer = new Barbecuer();
        BakeMuttonCommand bakeMuttonCommand1 = new BakeMuttonCommand(barbecuer);
        BakeMuttonCommand bakeMuttonCommand2 = new BakeMuttonCommand(barbecuer);
        BakeChickenWingCommand bakeChickenWingCommand = new BakeChickenWingCommand(barbecuer);

        //开始营业 顾客点菜
        Watier watier = new Watier();
        watier.setOrder(bakeMuttonCommand1);
        watier.setOrder(bakeMuttonCommand2);
        watier.setOrder(bakeChickenWingCommand);

        // 点菜完毕 通知厨房
        watier.Notify();

        //取消订单
        watier.cancelOrder(bakeMuttonCommand2);
        watier.Notify();
    }
}
//抽象命令类
abstract class Command{
    protected Barbecuer barbecuer;
    public Command(Barbecuer barbecuer){
        this.barbecuer = barbecuer;
        //抽象命令类 只需要确定烤肉串者是谁
    }
    public abstract void excuteCommand();

    public Barbecuer getBarbecuer() {
        return barbecuer;
    }

    public void setBarbecuer(Barbecuer receiver) {
        this.barbecuer = barbecuer;
    }
}
//烤肉串者
class Barbecuer{
    //烤羊肉
    public void BakeMutton(){
        System.out.println("烤羊肉串！");
    }
    //烤鸡翅
    public void BakeChickenWing(){
        System.out.println("烤鸡翅！");
    }
}
//具体命令类
//烤羊肉串
class BakeMuttonCommand extends Command{
    public BakeMuttonCommand(Barbecuer barbecuer){
        super(barbecuer);
    }
    @Override
    public void excuteCommand() {
        this.getBarbecuer().BakeMutton();
    }
}
//烤鸡翅
class BakeChickenWingCommand  extends Command{
    public BakeChickenWingCommand (Barbecuer barbecuer){
        super(barbecuer);
    }
    @Override
    public void excuteCommand() {
        this.getBarbecuer().BakeChickenWing();
    }
}
//服务员类 接受多个命令
class Watier{
    //增加存放具体命令得容器
    private List<Command> orders = new ArrayList<Command>();
    //设置订单
    public void setOrder(Command command){
        if (command.toString() == "Command.bakeChickenWingCommand"){
            System.out.println("服务员：鸡翅没有了，请点别的");
        }else {
            orders.add(command);
            System.out.println("增加订单：" + command.toString() + " 时间： "+ new Date());
        }
    }
    //取消订单
    public void cancelOrder(Command command){
        orders.remove(command);
        System.out.println("取消订单：" + command.toString() + " 时间： "+ new Date());
    }
    //通知全部执行
    public void Notify(){
        for (Command com:orders) {
            com.excuteCommand();
        }
    }
}
