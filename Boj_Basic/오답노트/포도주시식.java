import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n+1];
        int dp[] = new int[n+1];
        for(int i = 1; i<=n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
      
        dp[1] = arr[1];
        if(n>1){
            dp[2] = arr[1] + arr[2];
        }

        for(int i = 3; i<=n; i++){
            dp[i] = Math.max(dp[i-1], Math.max(arr[i] + dp[i-2], arr[i] + arr[i-1] + dp[i-3])); 
        }
        System.out.println(dp[n]);
    }
}

/**
 *      1 2 6 7 9 5 -> 2 6 9 5 / 22
 *
 *      dp[1] = 1
 *      dp[2] = arr[1] + arr[2] = 3
 *      dp[3] = Math.max(dp[i-1] -> 해당 arr 요소를 선택하지 않은 경우, Math.max(arr[i] + dp[i-2] -> 2번째 전의 dp와 현재 요소 선택, arr[i] + arr[i-1] + dp[i-3] -> 현재 요소와 이웃한 이전의 요소 + dp[i-3])       
 *
 */
