import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static boolean isPrime[] = new boolean[1000001]; // true -> 소수 x

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int length = isPrime.length;
        Arrays.fill(isPrime, true);

        for (int i = 2; i < length; i++) {
            for(int j = 3; j <=Math.sqrt(i);j+=2){
                if(i%j ==0){
                    isPrime[i] = false;
                    break;
                }
            }
        }

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            sb.append(N + " ").append("= ");

            boolean exist = false;
            for (int i = 3; i <= N; i += 2) {
                if (isPrime[i] && isPrime[N - i]) {
                    sb.append(i + " ").append("+ ").append(N - i).append('\n');
                    exist = true;
                    break;
                }
            }
            if (!exist) sb.append("Goldbach's conjecture is wrong").append('\n');

        }
        System.out.println(sb);
    }
}
