import java.util.ArrayList;
import java.util.List;

/**迭代器模式
 * foreach 的实现
 * 为遍历不同的聚集结构提供如开始 下一个 是否结束
 * 当前哪一项等统一接口
 * @author Bang
 * @date 2019/12/27  9:52
 */
public class Code_16_iteratorPattern {
    public static void main(String[] args) {
        //聚集对象
        ConCreateAggregate conCreateAggregate = new ConCreateAggregate();
        //上来的乘客
        conCreateAggregate.setObject(0,"邦邦");
        conCreateAggregate.setObject(1,"娇娇");
        conCreateAggregate.setObject(2,"伊一");
        conCreateAggregate.setObject(3,"圆圆");
        conCreateAggregate.setObject(4,"嘟嘟");
        //声明迭代器对象  上车的是那些人
        ConCreateIterator iterator = new ConCreateIterator(conCreateAggregate);
        Object item = iterator.first();
        while (!iterator.isDone()){
            System.out.println(iterator.currentItem() + "请买票！");
            iterator.next();
        }
    }
}
//Iterator 迭代器抽象类
//用于定义得到开始对象、下一对象、判断是否到结尾
//当前对象等抽象方式
//统一接口
abstract class Iterator{
    abstract Object first();
    abstract Object next();
    abstract boolean isDone();
    abstract Object currentItem();
}
//聚集抽象类
abstract class Aggregate{
    abstract Iterator createIterator();//创建迭代器
}
//具体聚集类 继承Aggreate
class ConCreateAggregate extends Aggregate{
    //声明一个泛型变量 用于存放聚合对象 用array list实现
    private List<Object> items = new ArrayList<Object>();
    @Override
    Iterator createIterator() {
        return new ConCreateIterator(this);
    }
    //返回聚集总数
    public int getCount(){
        return items.size();
    }
    public Object getObject(int index){
        return items.get(index);
    }
    public void setObject(int index,Object object){
        items.add(index,object);
    }
}

//具体迭代器  继承iterator
class ConCreateIterator extends Iterator{
    private ConCreateAggregate aggregate;
    private int current = 0;
    public ConCreateIterator(ConCreateAggregate aggregate){
        this.aggregate = aggregate;
    }

    @Override
    Object first() {
        return aggregate.getObject(0);
    }

    @Override
    Object next() {
        Object ret = null;
        current++;
        if (current < aggregate.getCount()){
            ret = aggregate.getObject(current);
        }
        return ret;
    }

    @Override
    boolean isDone() {
        return current >= aggregate.getCount();
    }

    @Override
    Object currentItem() {
        return aggregate.getObject(current);
    }
}