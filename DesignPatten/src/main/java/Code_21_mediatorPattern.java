import com.sun.org.apache.regexp.internal.RE;

/**中介者模式
 * @author Bang
 * @date 2020/1/8  17:11
 */
public class Code_21_mediatorPattern {
    public static void main(String[] args) {
        UnitedNationsSecurityCouncil council = new UnitedNationsSecurityCouncil();
        USA usa = new USA(council);
        Iraq iraq = new Iraq(council);

        council.setColleague1(usa);
        council.setColleague2(iraq);

        usa.declare("不准研制核武器，否则要发动战争！");
        iraq.declare("我们没有核武器，也不怕侵略");
    }
}
//联合国机构
abstract class UnitedNations {
    //声明
    public abstract void Declare(String message,Country colleague);
}
//国家类 类似于Colleague类
//国家
abstract class Country{
    protected UnitedNations mediator;
    public Country(UnitedNations mediator){
        super();
        this.mediator = mediator;
    }
}
//具体国家
class USA extends Country{
    public USA(UnitedNations mediator){
        super(mediator);
    }
    public void declare(String message){
        mediator.Declare(message,this);
    }
    //获取消息
    public void getMessage(String message){
        System.out.println("美国获取对方消息：" + message);
    }
}

class Iraq extends Country{
    public Iraq(UnitedNations mediator){
        super(mediator);
    }
    public void declare(String message){
        mediator.Declare(message,this);
    }
    //获取消息
    public void getMessage(String message){
        System.out.println("伊拉克获取对方消息：" + message);
    }
}
//联合国安全理事会 相当于ConcreateMediator类
class UnitedNationsSecurityCouncil extends UnitedNations{
    private USA colleague1;
    private Iraq colleague2;

    public USA getColleague1() {
        return colleague1;
    }

    public void setColleague1(USA colleague1) {
        this.colleague1 = colleague1;
    }

    public Iraq getColleague2() {
        return colleague2;
    }

    public void setColleague2(Iraq colleague2) {
        this.colleague2 = colleague2;
    }
    //声明
    @Override
    public void Declare(String message, Country colleague) {
        if (colleague == colleague1){
            colleague2.getMessage(message);
        }else {
            colleague1.getMessage(message);
        }
    }
}