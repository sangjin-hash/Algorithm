import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dist = new int[100001];
        boolean[] v = new boolean[100001];
        int[] from = new int[100001];

        Queue<Integer> q = new LinkedList<>();
        q.add(n);

        while(!q.isEmpty()){
            int x = q.remove();
            v[x] = true;

            if(0<x && x <= 50000){
                int[] dx = {-1,1};
                for(int i = 0; i< 2; i++){
                    int nx = x + dx[i];
                    if(!v[nx] && dist[nx] == 0){
                        dist[nx] = dist[x] + 1;
                        from[nx] = x;
                        v[nx] = true;
                        q.add(nx);
                    }
                    int teleport = 2*x;
                    if(!v[teleport] && dist[teleport] == 0){
                        dist[teleport] = dist[x] + 1;
                        from[teleport] = x;
                        v[teleport] = true;
                        q.add(teleport);
                    }
                }
            }else if(50001<= x && x < 100000){
                int[] dx = {-1,1};
                for(int i = 0; i< 2; i++){
                    int nx = x + dx[i];
                    if(!v[nx] && dist[nx] == 0){
                        dist[nx] = dist[x] + 1;
                        from[nx] = x;
                        v[nx] = true;
                        q.add(nx);
                    }
                }
            }else if(x == 100000){
                int nx = x - 1;
                if(!v[nx] && dist[nx] == 0){
                    dist[nx] = dist[x] + 1;
                    from[nx] = x;
                    v[nx] = true;
                    q.add(nx);
                }
            }else{
                int nx = x + 1;
                if(!v[nx] && dist[nx] == 0){
                    dist[nx] = dist[x] + 1;
                    from[nx] = x;
                    v[nx] = true;
                    q.add(nx);
                }
            }
        }
        sb.append(dist[k]).append('\n');

        Stack<Integer> stack = new Stack<>();
        stack.push(k);
        int z = k;
        while(z != n){
            stack.push(from[z]);
            z = from[z];
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb.toString());
    }
}
