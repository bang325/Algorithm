/**
 * @author Bang
 * @date 2019/11/15  16:36
 */
public class Pre_Exercise {
    public static class Cat{
        private int shoutNum = 3;
        private String name;
        private int age;

        public int getShoutNum() {
            return shoutNum;
        }

        public void Shout(){
            System.out.println("我的名字叫：" + name + " 今年 " + age + " 喵");
        }
        //方法重载，在不可改变原方法的基础上新增功能
        //方法重载：方法名相同，但是参数类型和个数必须要有所不同
        public Cat(String name){
            this.name = name;
        }
        public Cat(){
            this.name = "无名";
        }
        public Cat(String name,int age){
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Cat  cat = new Cat("咪咪");
        Cat  cat1 = new Cat();
        Cat  cat2 = new Cat("哈哈",10);
        cat.Shout();
        cat1.Shout();
        cat2.Shout();
    }
}
