import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[][] arr;
    static boolean[] visited;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n];

        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        go(0, 0);
        System.out.println(result);
    }

    public static void go(int index, int count){
        if(count == n/2){
            diff();
            return;
        }

        for(int i = index; i<n; i++){
            visited[i] = true;
            go(i+1, count+1);
            visited[i] = false;
        }
    }

    public static void diff(){
        int t1 = 0, t2 = 0;
        ArrayList<Integer> team1 = new ArrayList<>();
        ArrayList<Integer> team2 = new ArrayList<>();

        for(int i = 0; i<n; i++){
            if(visited[i]) team1.add(i);
            else team2.add(i);
        }

        for(int i = 0; i<n/2; i++){
            for(int j = 0; j<n/2; j++){
                if(i==j) continue;
                t1 += arr[team1.get(i)][team1.get(j)];
                t2 += arr[team2.get(i)][team2.get(j)];
            }
        }
        result = Math.min(Math.abs(t1-t2), result);
    }
}
