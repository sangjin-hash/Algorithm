import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] res = new int[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        int[] num = new int[n];
        for(int i = 0 ; i < n; i++){
            num[i] = Integer.parseInt(st1.nextToken());
        }

        Arrays.sort(num);
        go(0, n, m, num);
        System.out.println(sb.toString());
    }

    private static void go(int index, int n, int m, int[] num) {
        if(index == m){
            boolean flag = true;
            for(int i = 1; i<m; i++){
                if(res[i-1] > res[i]){
                    flag = false;
                    break;
                }
            }

            if(flag){
                for(int i = 0 ; i< m; i++){
                    sb.append(res[i]);
                    if(i != m-1) sb.append(" ");
                }
                sb.append('\n');
            }
            return;
        }

        for(int i = 0; i<n; i++){
            res[index] = num[i];
            go(index+1, n, m, num);
        }
    }
}
