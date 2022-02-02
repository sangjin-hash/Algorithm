import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int arr[] = new int[N];
        int dp[] = new int[N];

        // 순서를 뒤집어 최장 증가 부분 수열 문제로 변환한다.
        for(int i = N-1; i >= 0; i--){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // DP 테이블을 1로 초기화
        for(int i = 0; i<N; i++){
            dp[i] = 1;
        }

        // 가장 긴 증가하는 부분 수열(LIS) 알고리즘 수행 ( 0 <= j < i)
        for(int i = 1; i<N; i++)
            for (int j = 0; j < i; j++)
                if (arr[j] < arr[i]) dp[i] = Math.max(dp[i], dp[j] + 1);

        // 열외해야 하는 병사의 최소 수를 출력
        int maxValue = 0;
        for(int i = 0; i < N; i++) maxValue = Math.max(maxValue, dp[i]);
        System.out.println(N-maxValue);
    }
}
