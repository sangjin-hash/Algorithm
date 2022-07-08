import java.util.*;
import java.io.*;

public class Main{

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int arr[][] = new int[n][n];
        boolean v[] = new boolean[n];

        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        go(0,0, n,v, arr);
        System.out.println(min);
    }

    public static void go(int index, int count, int n, boolean[] v, int[][] arr){
        if(count == n/2){
            ArrayList<Integer> team1 = new ArrayList<>();
            ArrayList<Integer> team2 = new ArrayList<>();

            for(int i = 0; i<n; i++){
                if(v[i]) team1.add(i);
                else team2.add(i);
            }

            int t1 = 0, t2 = 0;
            for(int i = 0; i<n/2; i++){
                for(int j = 0; j<n/2; j++){
                    if(i == j) continue;
                    t1 += arr[team1.get(i)][team1.get(j)];
                    t2 += arr[team2.get(i)][team2.get(j)];
                }
            }
            min = Math.min(Math.abs(t1-t2), min);
            return;
        }

        for(int i = index; i<n; i++){
            v[i] = true;
            go(i+1,count+1, n, v, arr);
            v[i] = false;
        }
    }
}

/**
 *
 *
 *
 *
 */
