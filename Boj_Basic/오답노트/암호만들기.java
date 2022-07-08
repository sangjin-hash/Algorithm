import java.util.*;
import java.io.*;

public class Main{

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int l = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        char pw[] = new char[c];
        for(int i = 0; i<c; i++) pw[i] = st1.nextToken().charAt(0);
        Arrays.sort(pw);
        char res[] = new char[l];
        boolean v[] = new boolean[c];
        go(0, pw, l, res, c, v);
        System.out.println(sb);
    }

    public static void go(int index, char[] pw, int l, char[] res, int c, boolean[] v){
        if(index == l){
            if(isOk(res)){
                for(int i = 0; i<l; i++) sb.append(res[i]);
                sb.append('\n');
            }
            return;
        }

        for(int i = 0; i<c; i++){
            if(v[i]) continue;
            v[i] = true;
            res[index] = pw[i];
            if(index > 0 && res[index-1] - res[index] > 0){
                v[i] = false;
                continue;
            }
            go(index+1, pw, l, res, c ,v);
            v[i] = false;
        }
    }

    public static boolean isOk(char[] res){
        boolean result = false;

        int count_j = 0;
        int count_m = 0;

        for(int i = 0; i<res.length; i++){
            if(res[i] == 'a' || res[i] == 'e' || res[i] == 'i'
                    || res[i] == 'o' || res[i] == 'u') count_m++;
            else count_j++;
        }

        if(count_j >= 2 && count_m >= 1) result = true;
        else result = false;

        return result;
    }
}

/**
 *
 *  ...
 */
