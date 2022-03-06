import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = i+1;
            sb.append(arr[i]);
            if(i != n-1) sb.append(" ");
        }
        sb.append("\n");

        while(true){
            if(!next_permutation(n)) break;
        }

        System.out.println(sb.toString());
    }

    // 1 2 3      3 2 1
    // 1 3 2
    public static boolean next_permutation(int n){
        int i, j;
        if(n > 1){
            for(i = n-1; i>0; i--){
                if(arr[i-1] < arr[i]) break;
            }
            if(i == 0) return false;

            for(j = n-1; j>=i; j--){
                if(arr[i-1] < arr[j]) break;
            }

            swap(i-1, j);

            for(int k = 0; k < (n-i)/2; k++){
                swap(i+k, n-k-1);
            }

            for(int k =0; k<n; k++){
                sb.append(arr[k]);
                if(k!=n-1) sb.append(" ");
            }
            sb.append("\n");
            return true;
        }else{
            return false;
        }
    }

    public static void swap(int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
