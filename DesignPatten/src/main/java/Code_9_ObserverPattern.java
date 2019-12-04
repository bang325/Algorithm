import java.util.ArrayList;
import java.util.List;
/**观察者模式
 * @author Bang
 * @date 2019/12/3  17:18
 */
public class Code_9_ObserverPattern {
    public static void main(String[] args) {
        Secretary secretary = new Secretary();
        //看股票的同事
        Observer worker1 = new StockObserver("小雅", secretary);
        Observer worker2 = new StockObserver("小吖", secretary);
        Observer worker3 = new NBAObserver("小小", secretary);

        //前台记录两位同事
        secretary.attach(worker1);
        secretary.attach(worker2);
        secretary.attach(worker3);
        //移除worker2
        secretary.remove(worker2);
        //发现老板回来
        secretary.setAction("胡汉三回来了");
        //通知两个同事
        secretary.notifyObserver();
    }
}
//主题或抽象通知者
interface Subject{
    void attach(Observer observer);
    void remove(Observer observer);
    void  notifyObserver();
}
//具体通知者
class Secretary implements Subject{
    //同事列表
    private List<Observer> observerList = new ArrayList<Observer>();
    private String action;

    //增加
    @Override
    public void attach(Observer observer) {
        observerList.add(observer);
    }

    //移除
    @Override
    public void remove(Observer observer) {
        observerList.remove(observer);
    }

    //通知
    @Override
    public void notifyObserver() {
        for (Observer observer:observerList) {
            observer.update();
        }
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
//观察者类
abstract class Observer{
    protected String name;
    protected Secretary sub;

    public Observer(String name,Secretary sub){
        this.name = name;
        this.sub = sub;
    }
    protected abstract void update();
}

//具体观察者
class StockObserver extends Observer{
    public StockObserver(String name,Secretary sub){
        super(name,sub);
    }

    @Override
    protected void update() {
        System.out.println(sub.getAction() + name +
                "关闭股市行情，继续工作！");
    }
}
class NBAObserver extends Observer{
    public NBAObserver(String name,Secretary sub){
        super(name,sub);
    }

    @Override
    protected void update() {
        System.out.println(sub.getAction()+name+
                "关闭NBA直播，继续工作！");
    }
}