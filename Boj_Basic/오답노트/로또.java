import java.util.*;
import java.io.*;

public class Main{
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        do{
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int k = Integer.parseInt(st.nextToken());
            if(k == 0) break;

            int arr[] = new int[k];
            for(int i = 0; i<k; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            boolean v[] = new boolean[50];
            int res[] = new int[6];
            go(0, k, arr, v, res);
            sb.append('\n');
        }while(true);
        System.out.println(sb);
    }

    public static void go(int index, int k, int[] arr, boolean[] v, int[] res){
        if(index == 6){
            for(int i = 0; i<6; i++){
                sb.append(res[i]);
                if(i != 5) sb.append(" ");
            }
            sb.append('\n');
            return;
        }

        for(int i = 0; i<k; i++){
            if(v[arr[i]]) continue;
            v[arr[i]] = true;
            res[index] = arr[i];
            if(index > 0 && res[index-1] > res[index]){
                v[arr[i]] = false;
                continue;
            }
            go(index+1, k, arr, v, res);
            v[arr[i]] = false;
        }
    }
}

/**
 *
 *  ...
 */
