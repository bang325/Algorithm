/*
import jdk.nashorn.internal.ir.IfNode;

import java.util.Scanner;

*/
/**工厂模式
 * 简单工厂VS工厂模型有以下感悟：
 * 1、简单工厂的工厂类中包含了具体算法的逻辑判断，
 * 客户端只需要知道加、减、乘等就可以得到想要的运算结果，
 * 解决了具体算法的创建问题；而且客户端和算法没有什么耦合的地方
 * 2、工厂模式把原本简单工厂的逻辑判断放到了客户端去执行，增加了耦合度；
 * 但是工厂模式更好的体现了开放-闭合原则，更加的易于拓展和维护，
 * 比如，我现在需要加开根运算，平方运算等等，只需要拓展具体算法和增加算法生成工厂类就可以，
 * 完全不会去修改之前的逻辑；而简单工厂则不需要去修改工厂类里面的逻辑判断。
 * 如果从这个角度去理解，其实工厂模式也还是降低了客户端与业务的耦合度，只不过要在一定量的前提下才能体现出来。
 * 3、两种模式都有优点和缺点，具体应用要看实际情况而定
 * @author Bang
 * @date 2019/12/3  9:30
 *//*

public class FactoryPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个数字:");
        String numberA = sc.next();
        System.out.println("请输入计算符:");
        //用于jdk1.7之前 获取char
        // char calcChar = sc.next().charAt(0);
        // 用于jdk1.7及之后
        String operate = sc.next();
        System.out.println("请输入第二个数字:");
        String numberB = sc.next();
        double result = 0;
        Operation2 oper = null;
        IFactory operFactory = new AddFactory();
        try {
            oper = operFactory.CreateOpertion(operate);
            oper.set_numberA(Double.parseDouble(numberA));
            oper.set_numberB(Double.parseDouble(numberB));
            result = oper.GetResult();
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("分母不能为0");
            System.exit(0);
        }
        System.out.println("运算结果是："+result);
    }
}
//Opertion运算类
class Operation2 {
    private double _numberA = 0;
    private double _numberB = 0;

    public double get_numberA() {
        return _numberA;
    }

    public void set_numberA(double _numberA) {
        this._numberA = _numberA;
    }

    public double get_numberB() {
        return _numberB;
    }

    public void set_numberB(double _numberB) {
        this._numberB = _numberB;
    }

    public double GetResult() {
        double result = 0;
        return result;
    }
}
class OperationAdd2 extends Operation2 {
    @Override
    public double GetResult() {
        return get_numberA() + get_numberB();
    }
}

class OperationSub2 extends Operation2 {
    @Override
    public double GetResult() {
        return get_numberA() - get_numberB();
    }
}

class OperationMul2 extends Operation2 {
    @Override
    public double GetResult() {
        return get_numberA() * get_numberB();
    }
}

class OperationDiv2 extends Operation2 {
    @Override
    public double GetResult() {
        if (get_numberB() == 0) {
            throw new RuntimeException("除数不能为0");
        } else {
            return get_numberA() / get_numberB();
        }
    }
}
//
//工厂接口
interface IFactory{
    Operation2 CreateOpertion(String operate);
}

//各个具体工厂
//加法工厂
class AddFactory implements IFactory {
    @Override
    public Operation2 CreateOpertion(String operate) {
        return new OperationAdd2();
    }
}

//减法工厂
class SubFactory implements IFactory{
    @Override
    public Operation2 CreateOpertion(String operate) {
        return new OperationSub2();
    }
}

//乘法工厂
class MulFactory implements IFactory{
    @Override
    public Operation2 CreateOpertion(String operate) {
        return new OperationMul2();
    }
}
//除法工厂
class DivFactory implements IFactory{
    @Override
    public Operation2 CreateOpertion(String operate) {
        return new OperationDiv2();
    }
}*/


public class Code_5_FactoryPattern {
    public static void main(String[] args) {
        IFactory factory = new UnderGraduateFactory();
        LeiFeng student = factory.CreateLeiFeng();
        student.Cook();
        student.Sweep();
        IFactory factory1 = new VolunteerFactory();
        LeiFeng volunteer = factory1.CreateLeiFeng();
        volunteer.Sweep();
    }
}
//雷锋类
class LeiFeng{
    public void Sweep(){
        System.out.println("扫地");
    }
    public void Wash(){
        System.out.println("洗衣服");
    }
    public void Cook(){
        System.out.println("做饭");
    }
}

//学雷锋的大学生，继承雷锋类
class UnderGraduate extends LeiFeng{

}
//学雷锋的社区志愿者，继承雷锋类
class Volunteer extends LeiFeng{

}

//雷锋工厂
interface IFactory{
    LeiFeng CreateLeiFeng();
}
//学雷锋的大学生工厂
class UnderGraduateFactory implements IFactory{
    @Override
    public LeiFeng CreateLeiFeng() {
        return new UnderGraduate();
    }
}

//学雷锋的社区志愿者
class VolunteerFactory implements IFactory{
    @Override
    public LeiFeng CreateLeiFeng() {
        return new Volunteer();
    }
}