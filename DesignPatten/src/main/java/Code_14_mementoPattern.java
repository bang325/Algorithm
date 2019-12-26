/**备忘录模式
 * @author Bang
 * @date 2019/12/26  14:17
 */
public class Code_14_mementoPattern {
    public static void main(String[] args) {
        //大战boss前
        GameRole role = new GameRole();
        role.getInitState();
        role.stateDisplay();

        //保存进度
        RoleStateCaretaker roleStateCaretaker = new RoleStateCaretaker();
        roleStateCaretaker.setMemento(role.saveState());

        //大战boss时 损耗严重
        role.fight();
        role.stateDisplay();

        //恢复之前状态
        role.recoveryState(roleStateCaretaker.getMemento());
        role.stateDisplay();
    }
}
//角色状态存储箱
class RoleStateMemento{
    private int vit;//生命力
    private int atk;//攻击力
    public RoleStateMemento(int vit,int atk){
        this.vit = vit;
        this.atk = atk;
    }

    public int getVit() {
        return vit;
    }

    public void setVit(int vit) {
        this.vit = vit;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }
}
//角色状态管理者
class RoleStateCaretaker{
    private RoleStateMemento memento;

    public RoleStateMemento getMemento() {
        return memento;
    }

    public void setMemento(RoleStateMemento memento) {
        this.memento = memento;
    }
}
//游戏
class GameRole{
    //生命力
    private int vit;
    private int atk;//攻击力
    public int getVit() {
        return vit;
    }

    public void setVit(int vit) {
        this.vit = vit;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }
    //状态显示
    public void stateDisplay(){
        System.out.println("角色当前状态：");
        System.out.println("体力：" + getVit());
        System.out.println("攻击力：" + getAtk());
    }
    //获得初始状态
    public void getInitState(){
        setVit(100);
        setAtk(100);
    }
    //战斗
    public void fight(){
        setVit(100);
        setAtk(100);
    }
    //保存角色状态
    public RoleStateMemento saveState(){
        return (new RoleStateMemento(vit,atk));
    }
    //回复角色状态
    public void recoveryState(RoleStateMemento memento){
        setVit(memento.getVit());
        setAtk(memento.getAtk());
    }
}