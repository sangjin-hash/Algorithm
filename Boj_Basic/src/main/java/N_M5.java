import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int res[] = new int[10];     // 결과를 저장하는 배열
    static boolean isUse[] = new boolean[10001];       // 중복 허용 x

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int num[] = new int[n];
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i<n; i++){
            num[i] = Integer.parseInt(st1.nextToken());
        }

        Arrays.sort(num);
        go(0, n, m, num);
        System.out.println(sb.toString());
    }

    public static void go(int index, int n, int m, int[] num){
        if(index == m){
            for(int i = 0; i<m; i++){
                sb.append(res[i]);
                if(i != m-1) sb.append(" ");
            }
            sb.append('\n');
            return;
        }

        for(int i = 0; i<n; i++){
            if(isUse[num[i]]) continue;
            res[index] = num[i];
            isUse[num[i]] = true;
            go(index+1, n, m, num);
            isUse[num[i]] = false;
        }
    }
}
