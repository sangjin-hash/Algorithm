import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int res[] = new int[10];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        go(0, n, m);
        System.out.println(sb.toString());
    }

    public static void go(int index, int n, int m) {
        if (index == m) {
            boolean flag = true;
            for(int i = 1; i<m;i++){
                if(res[i-1] > res[i]){
                    flag = false;
                    break;
                }
            }

            if(flag){
                for (int i = 0; i < m; i++) {
                    sb.append(res[i]);
                    if (i != m - 1) sb.append(" ");
                }
                sb.append('\n');
            }
            return;
        }

        for (int i = 1; i <= n; i++) {
            res[index] = i;
            go(index + 1, n, m);
        }
    }
}
