/**
 * 装饰模式
 * @author Bang
 * @date 2019/11/29  16:05
 */
public class Code_3_DecoratePattern {
    public static void main(String[] args) {
        Person person = new Person("帮帮");
        System.out.println("第一次");
        Tshirts tshirts = new Tshirts();
        SportShoes sportShoes = new SportShoes();
        BigTrouser bigTrouser = new BigTrouser();
        bigTrouser.Decorate(person);
        tshirts.Decorate(bigTrouser);
        sportShoes.Decorate(tshirts);
        sportShoes.show();

        System.out.println("第二种");
        Shoes shoes = new Shoes();
        WearSuit wearSuit = new WearSuit();
        WearTie wearTie = new WearTie();
        wearSuit.Decorate(person);
        wearTie.Decorate(wearSuit);
        shoes.Decorate(wearTie);
        shoes.show();
    }
}
class Person{
    public Person(){

    }
    private String name;

    public Person(String name){
        this.name = name;
    }
    public void show(){
        System.out.println("打扮的：" + name);
    }
}
//服饰类
class Finery extends Person{
    protected Person component;
    //打扮
    public void Decorate(Person component){
        this.component = component;
    }

    @Override
    public void show() {
        if (component != null){
            component.show();
        }
    }
}
//具体服饰类
class Tshirts extends Finery{
    @Override
    public void show() {
        System.out.println("T恤");
        super.show();
    }
}
//具体服饰类
class BigTrouser extends Finery{
    @Override
    public void show() {
        System.out.println("垮裤");
        super.show();
    }
}
//具体服饰类
class Shoes extends Finery{
    @Override
    public void show() {
        System.out.println("皮鞋");
        super.show();
    }
}
class SportShoes extends Finery{
    @Override
    public void show() {
        System.out.println("安踏潮我看");
        super.show();
    }
}
class WearSuit extends Finery{
    @Override
    public void show() {
        System.out.println("西装");
        super.show();
    }
}

class WearTie extends Finery{
    @Override
    public void show() {
        System.out.println("领带");
        super.show();
    }
}

