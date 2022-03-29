import java.io.*;
import java.util.*;

class Pair{
    int x;
    int y;

    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static final int[] dx = {-2,-1,1,2,2,1,-1,-2};
    static final int[] dy = {1,2,2,1,-1,-2,-2,-1};
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            int l = Integer.parseInt(br.readLine());        // 한 변의 길이
            int dist[][] = new int[l][l];
            boolean v[][] = new boolean[l][l];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start_x = Integer.parseInt(st.nextToken());       // 나이트의 현재 좌표
            int start_y = Integer.parseInt(st.nextToken());

            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            int dest_x = Integer.parseInt(st1.nextToken());         // 도착하고자 하는 좌표
            int dest_y = Integer.parseInt(st1.nextToken());

            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(start_x, start_y));
            v[start_x][start_y] = true;

            while(!q.isEmpty()){
                Pair p = q.remove();
                int x = p.x;
                int y = p.y;

                for(int k = 0; k<8; k++){
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if(0<=nx && nx < l && 0<=ny && ny <l){
                        if(dist[nx][ny] == 0 && !v[nx][ny]){
                            dist[nx][ny] = dist[x][y]+1;
                            v[nx][ny] = true;
                            q.add(new Pair(nx, ny));
                        }
                    }
                }
            }
            sb.append(dist[dest_x][dest_y]).append('\n');
        }
        System.out.println(sb.toString());
    }
}
