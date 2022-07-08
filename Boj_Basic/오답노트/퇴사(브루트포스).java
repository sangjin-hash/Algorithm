import java.util.*;
import java.io.*;

public class Main{

    static int t[] = new int[21];
    static int p[] = new int[21];
    static int max = 0;

    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());

      for(int i = 1; i<=n; i++){
          StringTokenizer st = new StringTokenizer(br.readLine(), " ");
          t[i] = Integer.parseInt(st.nextToken());
          p[i] = Integer.parseInt(st.nextToken());
      }

      go(n, 1, 0);
      System.out.println(max);
    }

    public static void go(int n, int time, int pay){
        if(time == n+1){
            max = Math.max(max, pay);
            return;
        }

        if(time > n) return;
        go(n, time + t[time], pay + p[time]);
        go(n, time+1, pay);
    }
}

/**
 *
 *   1   2   3   4   5   6   7
 *               10  30  20  45
 *
 */
