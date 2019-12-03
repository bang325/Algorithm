/**建造者模式
 * @author Bang
 * @date 2019/12/3  16:57
 */
public class Code_10_BuilderPattern {
    public static void main(String[] args) {
        Director director = new Director();
        builder1 builder1 = new builder1();
        builder2 builder2 = new builder2();
        director.build(builder1);
        director.build(builder2);
        Builder result1 = builder1.getResult();
        Builder result2 = builder2.getResult();
        System.out.println(result1.toString());
        System.out.println(result2.toString());
    }
}
//具体产品（建造对象）：
class Builder{
    protected String name;
    protected String age;
    protected String sex;
    protected String height;
    protected String weight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "名字:" + this.name +",性别:" + this.sex + ",身高：" + this.height
                + ",体重:" + this.weight + ",年龄：" +  this.age;
    }
}

//抽象接口
interface buider{
    void buildName();
    void buildAge();
    void buildSex();
    void buildHeight();
    void buildWeight();
}

//具体建造者1：
class builder1 implements buider{
    Builder B1 = new Builder();

    @Override
    public void buildName() {
        B1.setName("cook");
    }

    @Override
    public void buildAge() {
        B1.setAge("18");
    }

    @Override
    public void buildSex() {
        B1.setSex("男");
    }

    @Override
    public void buildHeight() {
        B1.setHeight("178");
    }

    @Override
    public void buildWeight() {
        B1.setWeight("65Kg");
    }
    public Builder getResult(){
        return B1;
    }

}
//具体建造者2：
class builder2 implements buider{
    Builder B2 = new Builder();

    @Override
    public void buildName() {
        B2.setName("bang");
    }

    @Override
    public void buildAge() {
        B2.setAge("14");
    }

    @Override
    public void buildSex() {
        B2.setSex("男");
    }

    @Override
    public void buildHeight() {
        B2.setHeight("188");
    }

    @Override
    public void buildWeight() {
        B2.setWeight("75Kg");
    }
    public Builder getResult(){
        return B2;
    }
}

//指挥者
class Director{
     void build(buider b){
        b.buildHeight();
        b.buildWeight();
        b.buildSex();
        b.buildAge();
        b.buildName();
    }
}
