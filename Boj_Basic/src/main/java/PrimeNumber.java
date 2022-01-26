import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int count = 0;

        while(N-- > 0 ){
            int n = Integer.parseInt(st.nextToken());
            boolean result = isSosu(n);
            if(result && n != 1) count++;
        }
        System.out.println(count);
    }

    public static boolean isSosu(int n){
        boolean result = true;
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0) {
                return false;
            }
        }
        return result;
    }

}
