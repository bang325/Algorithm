/**模板方法
 * @author Bang
 * @date 2019/12/3  15:43
 */
public class Code_7_TemplatePattern {
    public static void main(String[] args) {
        System.out.println("学生A吵的试卷：");
        TestPaperA a = new TestPaperA();
        a.TestQuestion1();
        a.TestQuestion2();
        a.TestQuestion3();
        System.out.println("学生B吵的试卷：");
        TestPaperB b = new TestPaperB();
        b.TestQuestion1();
        b.TestQuestion2();
        b.TestQuestion3();
    }
}
abstract class TestPaper{
    /**
     * 模板方法，给出了逻辑的骨架，而逻辑的组成是一些相应的抽象操作，
     * 他们都推迟到子类实现。
     */

    public void TestQuestion1(){
        System.out.println("哪个目录存放用户密码信息( B  ) \n" +
                "A. /boot   B. /etc   C. /var   D. /dev");
        System.out.println("答案： " + Answer1());
    }

    public void TestQuestion2(){
        System.out.println("如果要列出一个目录下的所有文件需要使用命令行( C   )\n"+
                " A. ls –l  B. ls   C. ls –a(所有)   D. ls –d");
        System.out.println("答案： " + Answer2());
    }

    public void TestQuestion3(){
        System.out.println("下面哪个Linux命令可以一次显示一页内容？(C)  \n" +
                "A. pause  B. cat  C. more  D. grep");
        System.out.println("答案： " + Answer3());
    }
    //一些抽象行为，放到子类中去实现。也就是会变化的行为
    protected abstract String Answer1() ;
    protected abstract String Answer2() ;
    protected abstract String Answer3() ;
}

class TestPaperA extends TestPaper{
    @Override
    protected String  Answer1() {
        return "B";
    }

    @Override
    protected String Answer2() {
        return "C";
    }

    @Override
    protected String Answer3() {
        return "B";
    }
}
class TestPaperB extends TestPaper{
    @Override
    protected String  Answer1() {
        return "A";
    }

    @Override
    protected String Answer2() {
        return "A";
    }

    @Override
    protected String Answer3() {
        return "A";
    }
}
