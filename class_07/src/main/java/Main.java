// 本题为考试多行输入输出规范示例，无需提交，不计分。
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] arr = new char[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[i][j] = sc.nextLine().toCharArray()[j];
            }
        }
        int aR = sc.nextInt();//a点行
        int aC = sc.nextInt();//a点列
        int bR = sc.nextInt();//b点行
        int bC = sc.nextInt();//b点列
        char tmp = arr[aR][aC];
        arr[aR][aC] = arr[bR][bC];
        arr[bR][bC] = tmp;
        int res = 0;
        if (aR == bR){
            //列交换
            int resaR = 0;
            while (aC >=0 && aC < m){
                int t = aC;
                if (arr[aR][aC] == arr[aR][aC-1]){
                    resaR++;
                    aC--;
                }
                if (arr[aR][t] == arr[aR][t+1] && t < m){
                    resaR++;
                    t++;
                }
                resaR = resaR >=3 ? resaR : 0;
            }
            int resbR = 0;
            while (bC >=0 && bC < m){
                int t = bC;
                if (arr[bR][bC] == arr[bR][bC-1]){
                    resbR++;
                    bC--;
                }
                if (arr[bR][t] == arr[bR][t+1] && t <m){
                    resbR++;
                    t++;
                }
                resbR = resbR >=3 ? resbR : 0;
            }
            int resaC = 0;
            while (aR >=0 && aR < n){
                int t = aR;
                if (arr[aR-1][aC] == arr[aR][aC]){
                    resaC++;
                    aR--;
                }
                if (arr[t+1][aC] == arr[t][aC] && t<n){
                    resaC++;
                    t++;
                }
                resaC = resaC >=3 ? resaC : 0;
            }
            int resbC = 0;
            while (bR >=0 && bR < n){
                int t = bR;
                if (arr[bR-1][bC] == arr[bR][bC]){
                    resbC++;
                    bR--;
                }
                if (arr[t+1][bC] == arr[t][bC] && t < n){
                    resbC++;
                    t++;
                }
                resbC = resbC >=3 ? resbC : 0;
            }
            res = resaR + resaC + resbR + resbC;
        }
        if (aR == bR){
            //列交换
            int resaR = 0;
            while (aC >=0 && aC < m){
                int t = aC;
                if (arr[aR][aC] == arr[aR][aC-1]){
                    resaR++;
                    aC--;
                }
                if (arr[aR][t] == arr[aR][t+1] && t < m){
                    resaR++;
                    t++;
                }
                resaR = resaR >=3 ? resaR : 0;
            }
            int resbR = 0;
            while (bC >=0 && bC < m){
                int t = bC;
                if (arr[bR][bC] == arr[bR][bC-1]){
                    resbR++;
                    bC--;
                }
                if (arr[bR][t] == arr[bR][t+1] && t <m){
                    resbR++;
                    t++;
                }
                resbR = resbR >=3 ? resbR : 0;
            }
            int resaC = 0;
            while (aR >=0 && aR < n){
                int t = aR;
                if (arr[aR-1][aC] == arr[aR][aC]){
                    resaC++;
                    aR--;
                }
                if (arr[t+1][aC] == arr[t][aC] && t<n){
                    resaC++;
                    t++;
                }
                resaC = resaC >=3 ? resaC : 0;
            }
            int resbC = 0;
            while (bR >=0 && bR < n){
                int t = bR;
                if (arr[bR-1][bC] == arr[bR][bC]){
                    resbC++;
                    bR--;
                }
                if (arr[t+1][bC] == arr[t][bC] && t < n){
                    resbC++;
                    t++;
                }
                resbC = resbC >=3 ? resbC : 0;
            }
            res = resaR + resaC + resbR + resbC;
        }
        System.out.println(res);
    }
}