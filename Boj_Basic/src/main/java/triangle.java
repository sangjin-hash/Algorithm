import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int arr[][] = new int[n+1][n+1];
        int dp[][] = new int[n+1][n+1];

        for(int i=1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j<=i;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 초기 변수 설정
        dp[1][1] = arr[1][1];

        // 점화식
        for(int i = 2; i<=n;i++){
            for(int j = 1; j<=i; j++){
                if(j == 1) dp[i][j] = dp[i-1][j] + arr[i][j];
                else if(j == i) dp[i][j] = dp[i-1][j-1] + arr[i][j];
                else{
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + arr[i][j];
                }
            }
        }

        // 결과 출력
        int max = 0;
        for(int i = 1; i<=n; i++){
            max = Math.max(max, dp[n][i]);
        }
        System.out.println(max);
    }
}
