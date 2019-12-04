import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
/**观察者模式
 * @author Bang
 * @date 2019/12/3  17:18
 */
public class Code_9_ObserverPattern {
    public static void main(String[] args) {
        /*未使用委托
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
        secretary.setAction("胡汉三回来了 ");
        //通知两个同事
        secretary.notifyObserver();*/

        //使用委托
        Secretary secretary = new Secretary();
        //看股票的同事
        Observer worker1 = new StockObserver("小雅", secretary);
        Observer worker2 = new StockObserver("小吖", secretary);
        NBAObserver worker3 = new NBAObserver("小小", secretary);

        //前台记录两位同事
        secretary.addListener(worker1,"update");
        //secretary.addListener(worker2,"closeNBA");
        secretary.addListener(worker3,"closeNBA");
        //发现老板回来
        secretary.setAction("胡汉三回来了 ");
        //通知两个同事
        secretary.notifyObserver();
    }
}
/*未使用委托
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
}*/
/*
观察者模式的优缺点
        优点：很好地解耦了通知者与观察者，观察者不需要了解通知者内部是怎样实现的，
        方便于日后代码的修改，体现了依赖倒转的原则。
        缺点分析：
        分析：“上面该机的代码中抽象通知者还是依赖了抽象观察者，万一没有抽象观察者，
        那岂不是功能都完成不了啦！还有你这上面代码写的，所以对象更新的动作都一样的。
        万一我对象更新不一样呢？比如，看NBA球赛的听见班主任来了就跑去上厕所，
        而看漫画的听见班主任来了就继续看书。代码又应该怎么写呢？”
        小A，揉了揉惺忪的睡眼，疑惑地问道。小B说：“我去，我还以为你睡着了呢！
        原来你在听啊！我太高兴了。下面我们就利用一种叫做“事件委托”的东东去解决这个问题哈！”
        小A说：“我滴个神，什么叫事件委托啊？”
        解决方法1.解决方法，使用事件委托当观察者不实现Observer的时候，要采用事件委托。
*/
class Event{
    //要执行方法的对象
    private Object object;
    //要执行方法的名称
    private String methodName;
    //要执行方法的参数
    private Object[] params;
    //要执行方法的参数类型
    private Class[] paramTypes;

    public Event(){}
    public Event(Object object , String methodName,Object...args){
        this.methodName = methodName;
        this.object = object;
        this.params = args;
        contractParamTypes(this.params);
    }
    //根据参数数组生成参数类型数组
    private void contractParamTypes(Object[] params) {
        this.paramTypes = new Class[params.length];
        for (int i = 0; i < params.length; i++) {
            this.paramTypes[i] = params[i].getClass();
        }
    }

    //根据该对象的方法名，方法参数，利用反射机制，执行该方法
    public void invoke() throws Exception {
        Method method = object.getClass().getMethod(this.getMethodName(), this.getParamTypes());
        if (null == method){
            return;
        }
        method.invoke(this.getObject(),this.getParams());
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public Class[] getParamTypes() {
        return paramTypes;
    }

    public void setParamTypes(Class[] paramTypes) {
        this.paramTypes = paramTypes;
    }
}

class EventHandler{
    private List<Event> objects;
    public EventHandler(){
        objects = new ArrayList<>();
    }
    public void addEvent(Object object,String methodName,Object...args){
        objects.add(new Event(object,methodName,args));
    }
    //通知所有的对象执行指定的事件
    public void notifyA() throws Exception{
        for (Event e:objects) {
            e.invoke();
        }
    }
}
abstract class Subject{
    private EventHandler eventHandler = new EventHandler();
    private String action;

    public EventHandler getEventHandler() {
        return eventHandler;
    }

    public void setEventHandler(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
    abstract void addListener(Object object,String methodName,
                              Object...args);
    abstract void notifyObserver();
}
class Secretary extends Subject{
    @Override
    void addListener(Object object, String methodName, Object... args) {
        EventHandler handler = this.getEventHandler();
        handler.addEvent(object,methodName,args);
    }

    @Override
    void notifyObserver() {
        try {
            this.getEventHandler().notifyA();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

abstract class Observer{
    protected String name;
    protected Subject sub;
    public Observer(String name,Subject sub){
        this.name = name;
        this.sub = sub;
    }
    public abstract void update();
}

//具体观察者
class StockObserver extends Observer{
    public StockObserver(String name,Secretary sub){
        super(name,sub);
    }

    @Override
    public void update() {
        System.out.println(sub.getAction() + name +
                "关闭股市行情，继续工作！");
    }
}

class NBAObserver {
    protected String name;
    protected Subject sub;
    public NBAObserver(String name,Secretary sub){
        this.name = name;
        this.sub = sub;
    }

    public void closeNBA() {
        System.out.println(sub.getAction()+name+
                "关闭NBA直播，继续工作！");
    }
}
