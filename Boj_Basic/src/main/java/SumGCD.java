import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();


        while (N-- > 0) {
            long GCD = 0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int length = Integer.parseInt(st.nextToken());

            int arr[] = new int[length];
            for(int i = 0; i<length; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 0; i<length-1;i++){
                for(int j = i+1; j<length;j++){
                    GCD += GCD(arr[i], arr[j]);
                }
            }
            sb.append(GCD).append('\n');
        }
        System.out.println(sb);
    }

    public static long GCD(int n, int m){
        long GCD = 1;

        while(true){
            if(n==m){
                GCD = n;
                break;
            }
            if(n > m) n -= m;
            else m -= n;
        }

        return GCD;
    }
}
