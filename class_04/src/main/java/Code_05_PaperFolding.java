/**
 * 折纸问题
 * 【题目】 请把一段纸条竖着放在桌子上，然后从纸条的下边向上方对折1次，
 * 压出折痕后展开。此时 折痕是凹下去的，
 * 即折痕 突起的方向指向纸条的背面。
 * 如果从纸条的下边向上方连续对折 2 次，压出折痕后展开，
 * 此时有三条折痕，从上到下依次是下折 痕、下折痕和上折痕。
 * 给定一 个输入参数N，代表纸条都从下边向上方连续对折N次，
 * 请从上到下打印所有折痕的方向。
 * 例如：N=1时，打印： down N=2时，打印： down down up
 *
 * 思路：当前结点左子树总是down(true),右子树为up(false)
 * 所以我们只要按照中序遍历这颗二叉树
 * @author Bang
 * @date 2019/8/13  17:21
 */
public class Code_05_PaperFolding {
    public static void printAllFolds(int N){
        //根节点的是down(第一次折的时候是往下的(往里凸))
        printProcess(1,N,true);
    }

    private static void printProcess(int i, int n, boolean down) {
        if (i > n){
            return;
        }
        printProcess(i+1,n,true);
        // 相当于往左子树跑(因为左子树永远是down(下))
        System.out.print(down ? "down " : "up ");//访问中间
        printProcess(i+1,n,false);//往右子树跑
    }

    public static void main(String[] args) {
        int N = 4;
        printAllFolds(N);
    }
}
