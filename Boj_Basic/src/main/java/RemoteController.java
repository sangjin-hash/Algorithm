import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int init = 100, count = Math.abs(n-init);
        int MAX = 999999; // 리모컨이 9 빼고 모두 고장났을 때 -> 최댓값

        // true 일 때 고장
        boolean broken[] = new boolean[10];

        if(m > 0){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i< m;i++){
                int button = Integer.parseInt(st.nextToken());
                broken[button] = true;
            }
        }

        for(int i = 0; i<= MAX; i++){
            String str = String.valueOf(i);     // 해당 int 값을 String으로 만들어주는 것
            int len = str.length();

            boolean isBreak = false;
            for(int j = 0; j<len; j++){
                if(broken[str.charAt(j) - '0']){
                    isBreak = true;      // 고장난 버튼을 눌렀을 때 break
                    break;
                }
            }
            if(!isBreak){
                int min = Math.abs(n - i) + len;
                count = Math.min(count, min);
            }
        }
        System.out.println(count);

    }
}
