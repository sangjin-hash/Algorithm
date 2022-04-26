import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair>{
    int x;
    int y;
    int count;

    public Pair(int x, int y, int count){
        this.x = x;
        this.y = y;
        this.count = count;
    }

    @Override
    public int compareTo(Pair o){
        return count - o.count;
    }
}

public class Main {
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // column
        int m = Integer.parseInt(st.nextToken()); // row

        int[][] map = new int[m+1][n+1];
        boolean[][] v = new boolean[m+1][n+1];

        for(int i = 1; i<=m; i++){
            String[] k = br.readLine().split("");
            for(int j = 1; j<=n; j++){
                map[i][j] = Integer.parseInt(k[j-1]);
            }
        }

        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.offer(new Pair(1,1,0));
        v[1][1] = true;

        while(!q.isEmpty()){
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            int cnt = p.count;

            int[] dx = {0,1,0,-1};
            int[] dy = {1,0,-1,0};

            if(x == m && y == n){
                answer = Math.min(cnt, answer);
                continue;
            }

            for(int i = 0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(1<= nx && nx <=m && 1<=ny && ny<=n){

                    if(!v[nx][ny]){
                        v[nx][ny] = true;
                        if(map[nx][ny] == 0) q.offer(new Pair(nx,ny, cnt));
                        else q.offer(new Pair(nx,ny, cnt+1));
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
