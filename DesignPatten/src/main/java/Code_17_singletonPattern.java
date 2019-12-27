/**单例模式
 * 1. 单例模式只能有一个实例。
 * 2. 单例类必须创建自己的唯一实例。
 * 3. 单例类必须向其他对象提供这一实例。
 * @author Bang
 * @date 2019/12/27  11:10
 */
public class Code_17_singletonPattern {

}

//线程安全的饿汉模式
//饿汉模式是线程安全的 在类的创建同时就已经创建好了一个静态的对象
//供系统使用，以后不在改变 无需关注多线程问题 写法简单
class SingleHungry{
    //自行实例化
    //static修饰
    private final static SingleHungry single =
            new SingleHungry();
    //私有化构造方法
    private SingleHungry(){

    }
    //向外发布
    public static SingleHungry getInstance(){
        return single;
    }
}
//线程安全的懒汉模式
//什么时候用 什么时候建
class SingletonDemo{
    //自行实例化
    //static修饰
    private static SingletonDemo instance;
    //私有化构造方法
    private SingletonDemo(){

    }
    //向外发布
    public static synchronized SingletonDemo getInstance(){
        if (instance == null){
            instance = new SingletonDemo();
        }
        return instance;
    }
}
//解释一下在并发时，双重校验锁法会有怎样的情景：
//  STEP 1. 线程A访问getInstance()方法，因为单例还没有实例化，所以进入了锁定块。
//  STEP 2. 线程B访问getInstance()方法，因为单例还没有实例化，得以访问接下来代码块，而接下来代码块已经被线程1锁定。
//  STEP 3. 线程A进入下一判断，因为单例还没有实例化，所以进行单例实例化，成功实例化后退出代码块，解除锁定。
//  STEP 4. 线程B进入接下来代码块，锁定线程，进入下一判断，因为已经实例化，退出代码块，解除锁定。
//  STEP 5. 线程A初始化并获取到了单例实例并返回，线程B获取了在线程A中初始化的单例。
//        理论上双重校验锁法是线程安全的，并且，这种方法实现了lazyloading。
//  Volatile关键字的作用: 禁止进行指令的重排序
//双重校验锁法
class singletonDemo{
    private volatile static singletonDemo instance;
    private singletonDemo(){
        System.out.println("singleton has loaded");
    }
    public static singletonDemo getInstance(){
        if (instance == null){
            synchronized (singletonDemo.class){
                if (instance == null){
                    instance = new singletonDemo();
                }
            }
        }
        return instance;
    }

}