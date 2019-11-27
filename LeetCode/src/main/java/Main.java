import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x;
        int[][] arr = new int[2][n+1];
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < n+1; j++){
                if (i == 0){
                    x = sc.nextInt();
                    arr[i][j] = x;
                }
                if (i == 1){
                    x = sc.nextInt();
                    arr[i][j] = x;
                    if (j == n){
                        arr[i][j] = 0;
                        break;
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n ; i++) {
            if (arr[0][i] + arr[0][i+1] < arr[1][i]){
                res += arr[0][i] + arr[0][i+1];
            }else {
                res += arr[1][i];
            }
        }
        System.out.println(res);
    }
}