import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] d = new int[n+1][n+1];
        for(int i =0; i<=n; i++){
            Arrays.fill(d[i], -1);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(1);       // 이모티콘 현재 개수 1개
        q.add(0);       // 클립보드 0개

        d[1][0] = 0;
        while(!q.isEmpty()){
            int s = q.remove();
            int c = q.remove();

            if(d[s][s] == -1){      // 복사할 경우
                d[s][s] = d[s][c] + 1;
                q.add(s);
                q.add(s);
            }

            if(s+c <= n && d[s+c][c] == -1){    // 붙혀넣기할 경우
                d[s+c][c] = d[s][c] + 1;
                q.add(s+c);
                q.add(c);
            }

            if(s-1 >= 0 && d[s-1][c] == -1){
                d[s-1][c] = d[s][c] + 1;
                q.add(s-1);
                q.add(c);
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<=n; i++){
            if(d[n][i] != -1){
                min = Math.min(d[n][i], min);
            }
        }
        System.out.println(min);
    }
}
