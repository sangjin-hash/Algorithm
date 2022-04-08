import java.io.*;
import java.util.*;

class Pair {
    int x;

    public Pair(int x) {
        this.x = x;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());   // 수빈이 위치
        int k = Integer.parseInt(st.nextToken());   // 동생 위치

        boolean[] v = new boolean[100001];
        int[] dist = new int[100001];

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(n));
        v[n] = true;

        while (!q.isEmpty()) {
            Pair p = q.remove();
            int x = p.x;

            int teleport = 2 * x;
            if (0 < x && x <= 50000) {
                int[] dx = {-1, 1};
                for (int i = 0; i < 2; i++) {
                    int nx = x + dx[i];
                    if (dist[nx] == 0 && !v[nx]) {
                        v[nx] = true;
                        dist[nx] = dist[x] + 1;
                        q.add(new Pair(nx));
                    }
                }
                if(dist[teleport] == 0 && !v[teleport]) {
                    v[teleport] = true;
                    dist[teleport] = dist[x] + 1;
                    q.add(new Pair(teleport));
                }
            } else if (x > 50000 && x < 100000) {
                int[] dx = {-1,1};
                for (int i = 0; i < 2; i++) {
                    int nx = x + dx[i];
                    if (dist[nx] == 0 && !v[nx]) {
                        v[nx] = true;
                        dist[nx] = dist[x] + 1;
                        q.add(new Pair(nx));
                    }
                }
            }else if(x == 100000){
                int nx = x - 1;
                if (dist[nx] == 0 && !v[nx]) {
                    v[nx] = true;
                    dist[nx] = dist[x] + 1;
                    q.add(new Pair(nx));
                }
            }
            else {
                int nx = x + 1;
                if (dist[nx] == 0 && !v[nx]) {
                    v[nx] = true;
                    dist[nx] = dist[x] + 1;
                    q.add(new Pair(nx));
                }
            }
        }
        System.out.println(dist[k]);
    }
}
