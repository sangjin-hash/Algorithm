import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int arr[] = new int[n];
        for(int i = 0; i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(nextOrder(arr, n)){
            System.out.println(sb.toString());
        }else{
            System.out.println(-1);
        }
    }

    public static boolean nextOrder(int arr[], int n){

        int i, j;

        if(n>1){
            //(1) A[i-1] < A[i]를 만족하는 가장 작은 i를 찾는다.(진행방향: <-)
            for(i = n-1; i > 0; i--){
                if(arr[i-1] < arr[i]) break;
            }
            if(i==0) return false;

            //(2) j>=i 이면서 A[j] > A[i-1]를 만족하는 가장 작은 j를 찾는다. (진행방향 <-)
            for(j = n-1; j >= i; j--){
                if(arr[j] > arr[i-1]) break;
            }

            //(3) A[i-1]과 A[j]를 swap한다.
            swap(arr, i-1, j);

            //(4) A[i]부터 순열을 뒤집는다.
            for(int k = 0; k < (n-i)/2; k++){
                swap(arr, k+i, n-k-1);
            }

            //(5) 결과출력
            for(int k = 0; k<n; k++){
                sb.append(arr[k]);
                if(k != n-1) sb.append(" ");
            }
            return true;
        }else{
            return false;
        }
    }

    public static void swap(int arr[], int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
