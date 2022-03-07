import java.util.*;
import java.io.*;

public class Main {

    static int[] arr; // 1부터 n까지 경로를 저장할 배열
    static int[][] cost; // 노드 간 비용

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n];
        cost = new int[n][n];

        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++){
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i<n; i++){
            arr[i] = i+1;
        }

        int min = Integer.MAX_VALUE;
        while(true){
            min = Math.min(min_value(n), min);
            if(!next_permutation(n)) break;
        }
        System.out.println(min);
    }

    public static boolean next_permutation(int n){
        int i,j;

        for(i = n-1; i>0; i--){
            if(arr[i-1] < arr[i]) break;
        }
        if(i == 0) return false;

        for(j = n-1; j>=i;j--){
            if(arr[i-1] < arr[j]) break;
        }

        swap(i-1, j);

        for(int k = 0; k<(n-i)/2; k++){
            swap(k+i, n-k-1);
        }

        return true;
    }

    public static void swap(int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static int min_value(int n){
        int result = 0;
        boolean flag = true;

        for(int i = 0; i<n-1; i++){
            if(cost[arr[i]-1][arr[i+1]-1] == 0){
                flag = false;
                break;
            }
            result += cost[arr[i]-1][arr[i+1]-1];
        }

        if(cost[arr[n-1]-1][arr[0]-1] == 0 || !flag){
            return Integer.MAX_VALUE;
        }else{
            result += cost[arr[n-1]-1][arr[0]-1];
            return result;
        }
    }

}
