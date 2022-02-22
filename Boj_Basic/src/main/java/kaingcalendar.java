import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int count = x;
            int res = 0;
            int len = M*N / gcd(M,N);

            if(M>=N){
                while(true){
                    res = count % N;
                    if(res==0) res = N;
                    if(res==y) break;
                    else{
                        count += M;
                        if(count > len){
                            count = -1;
                            break;
                        }
                    }
                }
            }else{
                while(true){
                    res = count % N;
                    if(res==0) res = N;
                    if(res==y) break;
                    else{
                        count += M;
                        if(count > len){
                            count = -1;
                            break;
                        }
                    }
                }
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }

    //최대공약수
    public static int gcd(int m, int n){
        int gcd = 0;

        if(n == 0){
            gcd = m;
            return gcd;
        }else{
            return gcd(n, m % n);
        }
    }
}
