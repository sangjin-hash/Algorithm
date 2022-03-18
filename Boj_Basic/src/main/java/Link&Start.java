import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[][] arr;
    static int result = Integer.MAX_VALUE;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n];

        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        go(0);
        System.out.println(result);
    }

    public static void go(int index){
        if(index == n) return;

        for(int i = index; i<n; i++){
            visited[i] = true;
            diff();
            go(i+1);
            visited[i] = false;
        }
    }

    private static void diff() {
        ArrayList<Integer> team1 = new ArrayList<>();
        ArrayList<Integer> team2 = new ArrayList<>();
        int t1 = 0, t2 = 0;

        for(int i = 0; i<n; i++){
            if(visited[i]) team1.add(i);
            else team2.add(i);
        }

        for(int i = 0; i<team1.size(); i++){
            for(int j = 0; j<team1.size(); j++){
                t1 += arr[team1.get(i)][team1.get(j)];
            }
        }

        for(int i = 0; i<team2.size(); i++){
            for(int j = 0; j<team2.size(); j++){
                t2 += arr[team2.get(i)][team2.get(j)];
            }
        }
        result = Math.min(result, Math.abs(t1-t2));
    }
}
