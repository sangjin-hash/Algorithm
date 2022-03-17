import java.io.*;
import java.util.*;

public class Main {

    static char[] alpha;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int l = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        alpha = new char[c];
        String pass="";
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < c; i++){
            alpha[i] = st1.nextToken().charAt(0);
        }
        Arrays.sort(alpha);
        go(l, pass,0);
        System.out.println(sb.toString());
    }

    public static void go(int count,String pass,int index){
        if(pass.length() == count){     //정답을 찾은 경우
            if(check(pass)){
                sb.append(pass).append('\n');
                return;
            }
        }

        if(index >= alpha.length) return; // 불가능 조건
        go(count, pass + alpha[index], index+1); // i 번째 알파벳을 사용할 경우
        go(count, pass, index+1); // i 번째 알파벳을 사용하지 않을 경우
    }

    private static boolean check(String pass) {
        int mo= 0, ja =0;
        for(int i = 0; i<pass.length(); i++){
            char c = pass.charAt(i);
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') mo++;
            else ja++;
        }
        if(mo >= 1 && ja >=2) return true;
        else return false;
    }
}
