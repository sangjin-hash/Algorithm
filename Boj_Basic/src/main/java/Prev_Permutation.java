import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        arr = new int[n];
        for(int i = 0; i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(prev_Permutation(n)){
            System.out.println(sb.toString());
        }else{
            System.out.println(-1);
        }
    }

    /*

    6 1 2 3 4 5

    이전 순열 : 5 6 4 3 2 1



    (1) A[i-1] > A[i] 인 가장 큰 i (진행 방향 <-)
    i = 1

    (2) j>=i 이면서 A[j] < A[i-1]을 만족하는 가장 큰 j를 찾는다 (진행방향 <-)
    j = 5

    (3) A[i-1]와 A[j]를 swap
    5 1 2 3 4 6

    (4) i부터 j까지 순서를 바꾼다.
    5 6 4 3 2 1

    */

    public static boolean prev_Permutation(int n){
        int i, j;

        if(n > 1){
            // 1 step
            for(i = n-1; i > 0; i--){
                if(arr[i-1] > arr[i]) break;
            }
            if(i == 0) return false;

            // 2 step
            for(j = n-1; j >= i; j--){
                if(arr[j] < arr[i-1]) break;
            }

            // 3 step
            swap(i-1, j);

            // 4 step
            for(int k = 0; k < (n-i)/2; k++){
                swap(k+i, n-k-1);
            }

            // 5 step : 결과 출력
            for(int k = 0; k<n; k++){
                sb.append(arr[k]);
                if(k != n-1) sb.append(" ");
            }
            return true;
        }else return false;
    }

    public static void swap(int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
