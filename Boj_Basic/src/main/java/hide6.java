import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        int arr[] = new int[N]; // 동생들 위치 좌표 배열
        int sub[] = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());
            sub[i] = Math.abs(arr[i] - S);
        }

        for (int j = 0; j < N - 1; j++) {
            sub[j + 1] = gcd(sub[j], sub[j + 1]);
        }
        System.out.println(sub[N - 1]);
    }

    public static int gcd(int a, int b) {
        if(b == 0)
            return a;
        else
            return gcd(b, a % b);
    }
}
