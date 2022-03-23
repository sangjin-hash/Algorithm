import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int arr[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            // st1.nextToken()에 123 모두 다들어감
            String[] strArr = new String[n];
            strArr = br.readLine().split(""); //빈칸없이 자르기 해결하기
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(strArr[j]);
            }
        }

        int ans = 0;
        for (int s = 0; s < (1 << n * m); s++) {
            int sum = 0;

            // 0 : 가로, 1 : 세로
            /* k 구하는 공식
            ex) n = 4 , m = 4 일때
            i/j  0   1   2   3
            0    0   1   2   3
            1    4   5   6   7
            2    8   9   10  11
            3    12  13  14  15

            16개에 대한 배열을 나타내, 비트마스크로 표현한다. 0과 1에따라 상태 분류
             */

            for (int i = 0; i < n; i++) {           // i -> 행
                int cur = 0;
                // 가로
                for (int j = 0; j < m; j++) {       // j -> 열
                    int k = i * m + j;
                    if ((s & (1 << k)) == 0) {      // k가 포함되지 않음
                        cur = cur * 10 + arr[i][j]; //가장 처음에 선택된 수가 맨 앞에 들어가게 하는 로직.
                    } else {                      // k가 포함
                        sum += cur;
                        cur = 0;
                    }
                }
                sum += cur;
            }
            // 세로
            for (int j = 0; j < m; j++) {           // j -> 열
                int cur = 0;
                for (int i = 0; i < n; i++) {
                    int k = i * m + j;
                    if ((s & (1 << k)) != 0) {      // k가 포함되지 않음
                        cur = cur * 10 + arr[i][j]; //가장 처음에 선택된 수가 맨 앞에 들어가게 하는 로직.
                    } else {                      // k가 포함
                        sum += cur;
                        cur = 0;
                    }
                }
                sum += cur;
            }
            ans = Math.max(ans, sum);
        }
        System.out.println(ans);
    }
}
