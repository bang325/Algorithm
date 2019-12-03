/**原型模式
 * @author Bang
 * @date 2019/12/3  11:47
 */
public class Code_6_prototypePattern {
    public static void main(String[] args) throws CloneNotSupportedException {
        Resume a = new Resume("邦邦");
        a.SetPersonalInfo("男",18);
        a.SetWorkExperience("2017-2019","阿里巴巴");
        Resume b = (Resume)a.clone();
        b.SetWorkExperience("2019-2020","奇安信");
        Resume c = (Resume)a.clone();
        c.SetPersonalInfo("女",16);
        c.SetWorkExperience("2012-2013","长江大学");
        a.Display();
        b.Display();
        c.Display();
    }
}
/*浅拷贝
//由于它是浅表复制，所以对于值类型，没什么问题，但是对于引用类型，就只是复制了引用，
对引用的对象还是指向了原来的对象，所以就会出现我给a、b、c三个引用设置‘工作经历’，
但却同时看到三个引用都是最后的设置是一样的，因为这三个引用都指向了同一个对象。”
//“你写的和说的都很好，就是这个原因，这叫做‘浅复制’，
被复制对象的所有变量都含有与原来的对象相同的值，而所有的对其他对象的引用都仍然指向原来的对象。
但我们可能更需要这样的一种需求，把要复制的对象所引用的对象都复制一遍。比如刚才的例子，
我们希望是a、b、c三个引用的对象都是不同的，复制时就一变二，二变三，此时，我们就叫这种方式为‘深复制’，
深复制把引用对象的变量指向复制过的新对象，而不是原有的被引用的对象。”
//“那如果‘简历’对象引用了‘工作经历’，‘工作经历’再引用‘公司’，‘公司’再引用‘职位’…这样一个引用一个，
很多层，如何办？”
//工作经历
class WorkExperience{
    private String workDate;
    private String workCompany;

    public String getWorkDate() {
        return workDate;
    }

    public void setWorkDate(String workDate) {
        this.workDate = workDate;
    }

    public String getWorkCompany() {
        return workCompany;
    }

    public void setWorkCompany(String workCompany) {
        this.workCompany = workCompany;
    }
}

class Resume implements Cloneable{
    private String name;
    private int age;
    private String sex;
    private WorkExperience work = new WorkExperience();
    public Resume(String nam){
        this.name = nam;
    }

    //设置个人信息
    public void SetPersonalInfo(String sex,int age){
        this.age = age;
        this.sex = sex;
    }
    //设置工作经历
    public void  SetWorkExperience(String timeArea , String company){
        work.setWorkCompany(company);
        work.setWorkDate(timeArea);
    }
    //显示
    public void Display(){
        System.out.println("Resume [name=" + name + ", sex=" + sex + "," +
                " age=" + age + ", workExperience=" + work.getWorkDate() +
                "  " + work.getWorkCompany() +"]");
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}*/
//工作经历
class WorkExperience implements Cloneable{
    private String workDate;
    private String workCompany;

    public String getWorkDate() {
        return workDate;
    }

    public void setWorkDate(String workDate) {
        this.workDate = workDate;
    }

    public String getWorkCompany() {
        return workCompany;
    }

    public void setWorkCompany(String workCompany) {
        this.workCompany = workCompany;
    }
    @Override
    public WorkExperience clone() throws CloneNotSupportedException {
        return (WorkExperience)super.clone();
    }
}

class Resume implements Cloneable{
    private String name;
    private int age;
    private String sex;
    private WorkExperience work = new WorkExperience();
    public Resume(String nam){
        this.name = nam;
    }

    //设置个人信息
    public void SetPersonalInfo(String sex,int age){
        this.age = age;
        this.sex = sex;
    }
    //设置工作经历
    public void  SetWorkExperience(String timeArea , String company){
        work.setWorkCompany(company);
        work.setWorkDate(timeArea);
    }
    //显示
    public void Display(){
        System.out.println("Resume [name=" + name + ", sex=" + sex + "," +
                " age=" + age + ", workExperience=" + work.getWorkDate() +
                "  " + work.getWorkCompany() +"]");
    }
    @Override
    protected Resume clone() throws CloneNotSupportedException {
        Resume resume = new Resume(name);
        resume.age = this.age;
        resume.sex = this.sex;
        resume.work = work.clone();
        return resume;
    }
}