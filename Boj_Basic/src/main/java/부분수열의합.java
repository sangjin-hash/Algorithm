import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        arr = new int[n];

        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i< n; i++){
            arr[i] = Integer.parseInt(st1.nextToken());
        }

        for(int i = 1; i < (1<<n); i++){        // 1. 모든 부분수열을 만든다.
            int sum = 0;
            for(int k = 0; k<n;k++){
                if((i & (1<<k)) == 1<<k){       // k가 있는지 확인
                    sum += arr[k];
                }
            }
            if(sum == s) res++;
        }

        System.out.println(res);
    }
}
