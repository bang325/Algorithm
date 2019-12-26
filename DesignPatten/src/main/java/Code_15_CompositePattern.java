import java.util.ArrayList;
import java.util.List;

/**组合模式
 * @author Bang
 * @date 2019/12/26  15:02
 */
public class Code_15_CompositePattern {
    public static void main(String[] args) {
        //生成根节点，根上长出两个叶节点AB
        Composite root = new Composite("root");
        root.add(new Leaf("leafA"));
        root.add(new Leaf("leafB"));

        //跟上长出分支compositeX 分支上也有俩个叶 AB
        Composite compositeX = new Composite("CompositeX");
        compositeX.add(new Leaf("leafXA"));
        compositeX.add(new Leaf("leafXB"));

        root.add(compositeX);

        //在compositeX上再长出分支compositeXY 分支上也有两叶leafXYA XYB
        Composite compositeXY = new Composite("CompositeXY");
        compositeXY.add(new Leaf("leafXYA"));
        compositeXY.add(new Leaf("leafXYB"));

        compositeX.add(compositeXY);

        //跟上又长出两叶CD 可惜D没长成就被风吹走了
        root.add(new Leaf("leafC"));

        Leaf leafD = new Leaf("leafD");

        root.add(leafD);
        root.remove(leafD);
        //显示大树
        root.display(1);
    }
}
//component为组合中的对象声明接口 在适当情况下，实现所有类共有接口的默认行为
//声明一个接口用于访问和管理component的子部件
abstract class Component{
    protected String name;
    public Component(String name){
        this.name = name;
    }
    abstract void add(Component component);
    abstract void remove(Component component);
    abstract void display(int depth);
}
//leaf在组合中表示叶节点对象 叶节点没有子节点
class Leaf extends Component{
    public Leaf(String name){
        super(name);
    }
    @Override
    //由于叶子没有再增加分支和树叶 所以add和remove方法没有实现的意义
    //但是这样做可以消除叶节点和枝节点对象在抽象层次的区别
    //他们具有完全一致的接口
    void add(Component component) {
        System.out.println("cannot add to a leaf");
    }

    @Override
    void remove(Component component) {
        System.out.println("cannot remove from a leaf");
    }

    @Override
    //叶节点的具体方法 此处是显示其名称和级别
    void display(int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("-");
        }
        System.out.println(name);
    }
}
//composite定义有枝节点行为 又来存储子部件 在component接口中
//实现与子部件有关操作，比如add或者remove
class Composite extends Component{
    //一个子对象集合用来存储其下属的枝节点和叶节点
    private List<Component> children = new ArrayList<Component>();
    public Composite(String name){
        super(name);
    }

    @Override
    void add(Component component) {
        children.add(component);
    }

    @Override
    void remove(Component component) {
        children.remove(component);
    }

    @Override
    //显示其枝节点名称 并对其下级进行遍历
    void display(int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("-");
        }
        System.out.println(name);
        for (Component component:children) {
            component.display(depth+2);
        }
    }
}