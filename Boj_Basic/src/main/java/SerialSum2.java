import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int dp[][] = new int[2][n];
        dp[0][0] = dp[1][0] =arr[0];

        int max = arr[0];
        for(int i = 1; i<n; i++){
            dp[0][i] = Math.max(dp[0][i-1] + arr[i],arr[i]);
            dp[1][i] = Math.max(dp[0][i-1], dp[1][i-1]+arr[i]);
            max = Math.max(max,Math.max(dp[0][i], dp[1][i]));
        }

        System.out.println(max);
    }
}
