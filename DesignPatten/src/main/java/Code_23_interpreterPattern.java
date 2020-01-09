/**解释器模式
 * 解决的问题：如果一种特定类型的问题发生的频率足够高，
 * 那么可能就值得将该问题的各个实例表述为一个简单语句中的句子
 * 这样就可以构建一个解释器 该解释器通过解释这些句子来解决问题
 * @author Bang
 * @date 2020/1/9  11:01
 */
public class Code_23_interpreterPattern {
    public static void main(String[] args) {
        PlayContext playContext = new PlayContext();
        String content = "T 500 O 2 E 0.5 G 0.5 A 3 E 0.5 G 0.5 D 3 E 0.5 " +
                "G 0.5 A 0.5 O 3 C 1 O 2 A 0.5 G 1 C 0.5 E 0.5 D 3 ";
        playContext.setText(content);
        Expression expression = null;
        try {
            while (playContext.getText().length()> 0 ){
                String substring = playContext.getText().substring(0, 1);
                if (substring.equals("O")){
                    //当首字母是O时 实例化为音阶
                    expression = new Scale();
                }else if (substring.equals("T")){
                    //当首字母是T时 实例化为音速
                    expression = new Speed();
                } else {
                    //否则实例化为音符
                    expression = new Note();
                }
                expression.interpret(playContext);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
//音乐解释器的实现
//演奏内容
class PlayContext{
    //演奏文本
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
//表达式类
abstract class Expression{
    //解释器
    public void interpret(PlayContext playContext){
        if (playContext.getText().length() == 0){
            return;
        }else {
            String playKey = playContext.getText().substring(0, 1);
            playContext.setText(playContext.getText().substring(2));
            double playValue = Double.parseDouble(playContext.getText().substring(0,
                    playContext.getText().indexOf(" ")));
            playContext.setText(playContext.getText().substring(
                    playContext.getText().indexOf(" ") + 1));
            excute(playKey, playValue);
        }
    }

    protected abstract void excute(String playKey, double playValue);
}
//音符类
class Note extends Expression{
    @Override
    protected void excute(String playKey, double playValue) {
        String note = null;
        switch (playKey){
            case "C":
                note = "1";//如果获得的key是C 则演奏1（do）
                break;
            case "D":
                note = "2";
                break;
            case "E":
                note = "3";
                break;
            case "F":
                note = "4";
                break;
            case "G":
                note = "5";
                break;
            case "A":
                note = "6";
                break;
            case "B":
                note = "7";
                break;
        }
        System.out.print(" " + note + " ");
    }
}
//音阶类
class Scale extends Expression{
    @Override
    protected void excute(String playKey, double playValue) {
        String scale = null;
        int intKey = (int)playValue;
        switch (intKey){
            case 1:
                scale = "低音";
                break;
            case 2:
                scale = "中音";
                break;
            case 3:
                scale = "高音";
                break;
        }
        System.out.print(" " + scale + " ");
    }
}
//音速类
class Speed extends Expression{
    @Override
    protected void excute(String playKey, double playValue) {
        String speed = null;
        if (playValue < 500){
            speed = "快速";
        } else if (playValue >= 1000) {
            speed = "慢速";
        }else {
            speed = "中速";
        }
        System.out.print(" " + speed + " ");
    }
}