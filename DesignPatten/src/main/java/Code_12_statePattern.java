/**状态模式
 * @author Bang
 * @date 2019/12/25  9:29
 */
public class Code_12_statePattern {
    public static void main(String[] args) {
        //项目
        Work work = new Work();
        work.setHour(9);
        work.wirteProgram();

        work.setHour(10);
        work.wirteProgram();

        work.setHour(12);
        work.wirteProgram();

        work.setHour(13);
        work.wirteProgram();

        work.setHour(14);
        work.wirteProgram();

        work.setHour(17);
        work.wirteProgram();

        work.setFinish(false);
        work.wirteProgram();

        work.setHour(19);
        work.wirteProgram();

        work.setHour(22);
        work.wirteProgram();
    }
}
class Work{
    private State current;
    public Work(){
        current = new ForenoonState();
    }
    private double hour;

    public double getHour() {
        return hour;
    }

    public void setHour(double hour) {
        this.hour = hour;
    }

    private boolean finish = false;

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public State getCurrent() {
        return current;
    }

    public void setCurrent(State current) {
        this.current = current;
    }
    public void wirteProgram(){
        current.writeProgram(this);
    }
}

abstract class State{
    public abstract void writeProgram(Work w);
}

//上午工作状态
class ForenoonState extends State{
    @Override
    public void writeProgram(Work w) {
        if (w.getHour() < 12){
            System.out.println("当前时间：" + w.getHour() +
                    "点 上午工作 精神百倍");
        }else {
            w.setCurrent( new NoonState());
            w.wirteProgram();
        }
    }
}
//中午工作状态
class NoonState extends State{
    @Override
    public void writeProgram(Work w) {
        if (w.getHour() < 13){
            System.out.println("当前时间：" + w.getHour() +
                    "点 饿了 ，中午有点困");
        }else {
            w.setCurrent(new AfternoonState());
            w.wirteProgram();
        }
    }
}
//下午工作状态
class AfternoonState extends State{
    @Override
    public void writeProgram(Work w) {
        if (w.getHour() < 17){
            System.out.println("当前时间：" + w.getHour() +
                    "点 下午状态不错 继续努力" );
        }else {
            w.setCurrent(new EveningState());
            w.wirteProgram();
        }
    }
}
//晚上工作状态
class EveningState extends State{
    @Override
    public void writeProgram(Work w) {
        if (w.isFinish()){
            w.setCurrent(new RestState());
            w.wirteProgram();
        }else {
            if (w.getHour() < 21){
                System.out.println("当前时间： " + w.getHour() +
                        "点 加班ing");
            }else {
                w.setCurrent(new SleepingState());
                w.wirteProgram();
            }
        }
    }
}
//睡眠状态
class  SleepingState extends  State{
    @Override
    public void writeProgram(Work w) {
        System.out.println("当前时间： " + w.getHour() +
                " 点 不行了 睡觉了");
    }
}
//下班休息状态
class RestState extends State{
    @Override
    public void writeProgram(Work w) {
        System.out.println("当前时间： " + w.getHour() +
                "点 下班回家");
    }
}