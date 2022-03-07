import java.util.*;
import java.io.*;

public class Main {
    static int arr[];
    static int selected[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int n = Integer.parseInt(st.nextToken());
            if(n == 0) break;

            arr = new int[n];
            for(int i = 0; i<n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            selected = new int[n];
            for(int i = 0; i<6; i++){
                selected[i] = 0;   // 0인 경우 선택 o
                sb.append(arr[i]).append(" ");
            }
            for(int i = 6; i<n; i++){
                selected[i] = 1;   // 1인 경우 선택 x
            }
            sb.append("\n");

            while(true){
                if(!next_permutation(n)) break;
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static boolean next_permutation(int n){
        int i,j;

        for(i = n-1; i>0; i--){
            if(selected[i-1] < selected[i]) break;
        }
        if(i == 0) return false;

        for(j = n-1; j>=i;j--){
            if(selected[i-1] < selected[j]) break;
        }

        swap(i-1, j);

        for(int k = 0; k<(n-i)/2; k++){
            swap(k+i, n-k-1);
        }

        for(int k = 0; k<n; k++){
            if(selected[k] == 0) sb.append(arr[k]).append(" ");
        }
        sb.append("\n");

        return true;
    }

    public static void swap(int a, int b){
        int temp = selected[a];
        selected[a] = selected[b];
        selected[b] = temp;
    }

}
