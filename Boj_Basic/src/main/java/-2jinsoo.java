import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        if(n == 0){
            System.out.println(0);
            return;
        }
        while(n !=0) {
            int res = n % (-2);
             n = ( n / (-2 ));
            if(res<0){
                n++;
                res+=2;
            }

            sb.append(res);
       }
        System.out.println(sb.reverse());


    }
}
[출처] 백준 2089번 - (-2진수)|작성자 경딩
