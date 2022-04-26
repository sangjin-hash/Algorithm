import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dist = new int[100001];
        boolean[] v = new boolean[100001];
        Queue<Integer> q = new LinkedList<>();
        q.add(N);

        while(!q.isEmpty()){
            int x = q.remove();
            v[x] = true;

            int teleport = 2*x;
            if(0<=teleport && teleport<=100000 &&
                    !v[teleport] && dist[teleport] == 0){
                dist[teleport] = dist[x];
                v[teleport] = true;
                q.add(teleport);
            }

            int[] dx = {-1,1};
            for(int i = 0; i<2; i++){
                int nx = x + dx[i];

                if(0<=nx && nx<=100000 &&
                        !v[nx] && dist[nx] == 0){
                    dist[nx] = dist[x] + 1;
                    v[nx] = true;
                    q.add(nx);
                }
            }
        }
        System.out.println(dist[K]);
    }
}
