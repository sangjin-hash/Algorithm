import java.util.*;
import java.io.*;

public class Main{

    static StringBuilder sb = new StringBuilder();
    static boolean v[] = new boolean[9];
    static int r[] = new int[9];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        go(0,n,m);
        System.out.println(sb.toString());
    }

    public static void go(int index, int n, int m){
        if(index == m){
            for(int i = 0; i<m; i++){
                sb.append(r[i]).append(" ");
            }
            sb.append('\n');
        }

        for(int i = 1; i<=n; i++){
            if(v[i]) continue;
            r[index] = i;
            v[i] = true;
            go(index+1, n, m);
            v[i] = false;
        }
    }
}

/**
 *  4 3 입력 받음
 *  n = 4, m = 3
 *  1 2 3
 *  1 2 4
 *  1 3 2
 *  1 3 4
 *  1 4 2
 *  1 4 3
 *  ...
 */
