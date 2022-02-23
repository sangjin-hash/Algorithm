import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /*
    문제 이해
    N = 5 입력시 12345 -> 5자리
    N = 15 입력시 123456789101112131415 -> 21자리

    1~9 : N
    10 ~ 99 : +2씩
    ex) n = 15일 때 15는 길이가 2이므로, 2 * (15-10^1+1) + 1 * 9 = 21
    100 ~ 999 : +3씩
    ex) n = 120일 때 120은 길이가 3이므로, 3 * (252 - 10^2 +1) + 2 * 90 + 1 * 9 = 252
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String str = String.valueOf(n);
        int len = str.length();
        int count = 0;

        if(n < 10){
            System.out.println(n);
        }else{
            count += len * (n-Math.pow(10,len-1)+1);
            while(len-- > 0){
                count += len * 9 * Math.pow(10,len-1);
            }
            System.out.println(count);
        }
    }

}
