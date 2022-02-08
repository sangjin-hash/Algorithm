import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int arr[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int dp[] = new int[N];
        Arrays.fill(dp, 1);

        for(int i = 1; i < N; i++){
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i]) dp[i] = Math.max(dp[j]+1, dp[i]);
            }
        }

        int maxValue = 0;
        for(int i = 0; i< N; i++){
            maxValue = Math.max(dp[i], maxValue);
        }
        System.out.println(maxValue);
    }
}
