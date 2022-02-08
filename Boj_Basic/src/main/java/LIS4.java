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

        int lis = 1;

        int dp[] = new int[N];
        Arrays.fill(dp, 1);

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < N; i++){
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                    lis = Math.max(lis, dp[i]);
                }
            }
        }

        sb.append(lis).append('\n');

        Stack<Integer> s = new Stack<>();
        for(int i=N-1; i>=0; i--){
            if(dp[i] == lis){
                s.push(arr[i]);
                lis--;
            }
        }

        while(!s.isEmpty()){
            sb.append(s.pop() + " ");
        }

        System.out.println(sb);
    }
}
