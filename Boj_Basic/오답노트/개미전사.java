
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        int[] dp = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        dp[1] = Math.max(arr[1],arr[0]);
        
        for(int i = 2; i<n; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+arr[i]);
        }
        System.out.println(dp[n-1]);
    }
}
