import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**享元模式
 * 应用场景：如果一个应用程序使用了大量的对象，而大量得对象造成了很大得存储开销
 * 时就应该来考虑使用  还有就是对像得大多数状态可以外部状态 如果删除对象的外部状态
 * 那么可以用相对较少的共享对象取代很多组对象
 * @author Bang
 * @date 2020/1/9  10:10
 */
public class Code_22_FlyweightPattern {
    public static void main(String[] args) {
        WebSiteFactory webSiteFactory = new WebSiteFactory();
        WebSite site = webSiteFactory.getWebSiteCategory("产品展示");
        site.use(new Users("邦邦"));

        WebSite site1 = webSiteFactory.getWebSiteCategory("产品展示");
        site1.use(new Users("娇娇"));

        WebSite site2 = webSiteFactory.getWebSiteCategory("产品展示");
        site2.use(new Users("圆圆"));

        WebSite site3 = webSiteFactory.getWebSiteCategory("博客");
        site3.use(new Users("嘟嘟"));

        WebSite site4 = webSiteFactory.getWebSiteCategory("博客");
        site4.use(new Users("一一"));

        WebSite site5 = webSiteFactory.getWebSiteCategory("博客");
        site5.use(new Users("葡萄"));

        System.out.println("网站分类总数：" + webSiteFactory.getWebSiteCount());
    }
}

//用户
class Users{
    private String name;
    public Users(String name){
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
//网站抽象类
abstract class WebSite{
    public abstract void use(Users users);
}
//具体网站类
class ConcreteWebSite extends WebSite{
    private String name ;
    public ConcreteWebSite(String name){
        super();
        this.name = name;
    }

    @Override
    public void use(Users users) {
        System.out.println("网站分类： "+ name + " 用户："
        + users.getName());
    }
}
//网站工厂类
class WebSiteFactory{
    private Map<String, WebSite> flyweights = new HashMap<>();
    //获取网站分类 也是享元模式的核心代码，有就直接提供，没有就新建
    public WebSite getWebSiteCategory(String key){
        if (!flyweights.containsKey(key)){
            flyweights.put(key,new ConcreteWebSite(key));
        }
        return flyweights.get(key);
    }
    //获取网站分类总数
    public int getWebSiteCount(){
        return flyweights.size();
    }
}