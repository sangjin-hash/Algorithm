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

        int l_dp[] = new int[n];
        int r_dp[] = new int[n];
        Arrays.fill(l_dp, 1);
        Arrays.fill(r_dp,1);

        // LIS
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) l_dp[i] = Math.max(l_dp[j] + 1, l_dp[i]);
            }
        }

        // LDS
        for (int i = n-1; i >= 0; i--) {
            for (int j = n-1; j > i; j--) {
                if (arr[j] < arr[i]) r_dp[i] = Math.max(r_dp[j] + 1, r_dp[i]);
            }
        }

        int max = 0;
        for(int i = 0; i<n;i++){
            if(max < r_dp[i] + l_dp[i]){
                max = r_dp[i] + l_dp[i];
            }
        }
        System.out.println(max - 1);
    }
}
