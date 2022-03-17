import java.io.*;
import java.util.*;

public class Main {

    static int t[];
    static int p[];
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        t = new int[21];
        p = new int[21];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        go(n, 1, 0);
        System.out.println(max);
    }

    public static void go(int n, int time, int pay) {
        // 정답인 경우
        if (time == n+1) {
            max = Math.max(max, pay);
            return;
        }

        // 불가능인 경우
        if (time > n) return;
        //n일에 일을 할 경우
        go(n, time + t[time], pay + p[time]);
        //n일에 일을 하지 않을 경우
        go(n, time + 1, pay);

    }
}
