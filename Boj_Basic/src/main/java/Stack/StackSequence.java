
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        int[] stack = new int[N];

        int idx = 0;
        int start = 0;

        for(int i = 0; i < N ; i++){
            int num = Integer.parseInt(br.readLine());

            if(num > start){
                for(int j = start + 1; j <= num; j++){
                    stack[idx] = j;
                    idx++;
                    sb.append("+").append("\n");
                }
                start = num;
            }
            else if(stack[idx-1] != num){
                System.out.println("NO");
                System.exit(0);
            }

            idx--;
            sb.append("-").append("\n");
        }

        System.out.println(sb);
    }
}

