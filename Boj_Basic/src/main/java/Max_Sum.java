import java.util.*;
import java.io.*;

public class Main {

    static int[] arr;
    StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        arr = new int[n];

        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int max = 0;
        while(true){
            max = Math.max(max_value(n), max);
            if(!next_permutation(n)) break;
        }
        System.out.println(max);
    }

    // 1 4 8 10 15 20

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

    public static int max_value(int n){
        int result = 0;

        for(int i = 0; i<n-1; i++){
            result += Math.abs(arr[i] - arr[i+1]);
        }

        return result;
    }

}
