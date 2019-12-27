/**桥接模式
 * @author Bang
 * @date 2019/12/27  12:04
 */
public class Code_18_bridgePattern {
    public static void main(String[] args) {
        PhoneBrandN phoneBrandN = new PhoneBrandN();
        phoneBrandN.setPhoneSoft(new PhoneGame());
        phoneBrandN.run();
        phoneBrandN.setPhoneSoft(new PhoneAddressList());
        phoneBrandN.run();
        System.out.println("M品牌");
        PhoneBrandN phoneBrandM = new PhoneBrandN();
        phoneBrandM.setPhoneSoft(new PhoneGame());
        phoneBrandM.run();
        phoneBrandM.setPhoneSoft(new PhoneAddressList());
        phoneBrandM.run();
        phoneBrandM.setPhoneSoft(new PhoneMP3());
        phoneBrandM.run();

    }
}
//手机软件
abstract class PhoneSoft{
    public abstract void run();
}
//手机游戏
class PhoneGame extends PhoneSoft{
    @Override
    public void run() {
        System.out.println("运行手机游戏");
    }
}
//手机通讯录
class PhoneAddressList extends PhoneSoft{
    @Override
    public void run() {
        System.out.println("运行手机通讯录");
    }
}
//新增MP3播放
class PhoneMP3 extends PhoneSoft{
    @Override
    public void run() {
        System.out.println("MP3播放");
    }
}
//手机品牌
abstract class PhoneBrand{
    protected PhoneSoft phoneSoft;
    //设置手机软件
    public void setPhoneSoft(PhoneSoft phoneSoft){
        this.phoneSoft = phoneSoft;
    }
    //运行
    public abstract void  run();
}
//手机品牌N
class PhoneBrandN extends PhoneBrand{
    @Override
    public void run() {
        phoneSoft.run();
    }
}
//手机品牌M
class PhoneBrandM extends PhoneBrand{
    @Override
    public void run() {
        phoneSoft.run();
    }
}
