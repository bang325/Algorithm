import java.util.Scanner;

/**
 * 简单工厂：由一个工厂对象决定创建出哪一种产品类的实例
 *
 * @author Bang
 * @date 2019/11/27  15:22
 */
public class Code_1_simpleFactory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个数字:");
        String numberA = sc.next();
        System.out.println("请输入计算符:");
        //用于jdk1.7之前 获取char
        // char calcChar = sc.next().charAt(0);
        // 用于jdk1.7及之后
        String operate = sc.next();
        System.out.println(" 请输入第二个数字:");
        String numberB = sc.next();
        double result = 0;
        Operation oper = null;
        try {
            oper = OperationFactory.createOperate(operate);
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
class Operation {
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

//加减乘除类
class OperationAdd extends Operation {
    @Override
    public double GetResult() {
        return get_numberA() + get_numberB();
    }
}

class OperationSub extends Operation {
    @Override
    public double GetResult() {
        return get_numberA() - get_numberB();
    }
}

class OperationMul extends Operation {
    @Override
    public double GetResult() {
        return get_numberA() * get_numberB();
    }
}

class OperationDiv extends Operation {
    @Override
    public double GetResult() {
        if (get_numberB() == 0) {
            throw new RuntimeException("除数不能为0");
        } else {
            return get_numberA() / get_numberB();
        }
    }
}

//简单运算工厂类
class OperationFactory {
    public static Operation createOperate(String operate) {
        Operation oper = null;
        switch (operate) {
            case "+":
                oper = new OperationAdd();
                break;
            case "-":
                oper = new OperationSub();
                break;
            case "*":
                oper = new OperationMul();
                break;
            case "/":
                oper = new OperationDiv();
                break;

        }
        return oper;
    }
}

