import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        long five =0, two = 0;
        five = fiveCount(n);
        two = twoCount(n);

        five -= fiveCount(n-m);
        two -= twoCount(n-m);

        five -= fiveCount(m);
        two -= twoCount(m);

        System.out.println(five <= two ? five : two);
    }
    public static long fiveCount(long n){
        long count = 0;

        for(long i = 5; i<=n; i*=5){
            count += n/i;
        }
        return count;
    }

    public static long twoCount(long n){
        long count = 0;
        for(long i = 2; i<=n; i*=2){
            count += n/i;
        }
        return count;
    }
}
