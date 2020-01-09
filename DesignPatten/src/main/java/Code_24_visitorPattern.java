import java.util.ArrayList;
import java.util.List;

/**访问模式 要把处理从数据结构分离出来
 * 把数据结构和作用于结构之上的操作之间的耦合解脱开
 * 使得操作集合可以相对自由的演化
 * @author Bang
 * @date 2020/1/9  14:45
 */
public class Code_24_visitorPattern {
    public static void main(String[] args) {
        //在对象结构中加入要对比的 男人 和 女人
        ObjectStructure objectStructure = new ObjectStructure();
        objectStructure.attach(new Man());
        objectStructure.attach(new Woman());

        //成功时的反应
        Success success = new Success();
        objectStructure.display(success);

        //失败时的反应
        Failing failing = new Failing();
        objectStructure.display(failing);

        //恋爱时的反应
        Love love = new Love();
        objectStructure.display(love);
    }
}
//状态类  抽象的状态
abstract class Action{
    //得到男人结论或反应
    public abstract void getManConclusion(Man concreteElementA);

    //得到女人结论或反应
    public abstract void getWomanConclusion(Woman concreteElementB);
}

//人的抽象类
abstract class Human{
    //接受
    public abstract void accept(Action visitor);//用来获得状态的对象
}
//男人
class Man extends Human{
    @Override
    public void accept(Action visitor) {
        visitor.getManConclusion(this);
    }
}

//女人
class Woman extends Human{
    @Override
    public void accept(Action visitor) {
        visitor.getWomanConclusion(this);
    }
}


//成功状态
class Success extends Action{
    @Override
    public void getManConclusion(Man concreteElementA) {
        System.out.println(concreteElementA.getClass().getSimpleName() +" "+
                this.getClass().getSimpleName()
        +" 时，背后多半有一个伟大的女人");
    }

    @Override
    public void getWomanConclusion(Woman concreteElementB) {
        System.out.println(concreteElementB.getClass().getSimpleName() +
               " " + this.getClass().getSimpleName()
                +" 时，背后多半有一个不成功的男人");
    }
}
//失败状态
class Failing extends Action{
    @Override
    public void getManConclusion(Man concreteElementA) {
        System.out.println(concreteElementA.getClass().getSimpleName() +
                " " + this.getClass().getSimpleName()
        +" 闷头喝酒，谁也不用劝。");
    }

    @Override
    public void getWomanConclusion(Woman concreteElementB) {
        System.out.println(concreteElementB.getClass().getSimpleName() +
                " " +this.getClass().getSimpleName()
        +" 眼泪汪汪，谁也劝不了。");
    }
}

//恋爱状态
class Love extends Action{
    @Override
    public void getManConclusion(Man concreteElementA) {
        System.out.println(concreteElementA.getClass().getSimpleName() +
                " " + this.getClass().getSimpleName()
                +" 时，凡事不懂也要装懂");
    }

    @Override
    public void getWomanConclusion(Woman concreteElementB) {
        System.out.println(concreteElementB.getClass().getSimpleName() +
                " " + this.getClass().getSimpleName()
                +" 时，凡事懂也要装不懂");
    }
}

//对象结构类
//由于总是需要男人和女人 在不同状态下的对比，所以我们需要一个
// 对象结构 类来针对不同的 状态 遍历 男人 和 女人 得到不同的反应
class ObjectStructure{
    private List<Human> elements = new ArrayList<Human>();
    //增加
    public void attach(Human human){
        elements.add(human);
    }
    //移除
    public void detach(Human human){
        elements.remove(human);
    }
    //查看显示
    public void display(Action visitor){
        for (Human e:elements) {
            e.accept(visitor);
        }
    }
}