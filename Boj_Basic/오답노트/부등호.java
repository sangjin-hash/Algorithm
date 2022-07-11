import java.util.*;
import java.io.*;

public class Main{
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static boolean v[] = new boolean[10];
    static ArrayList<String> res = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        char arr[] = new char[n];
        for(int i = 0; i<n; i++){
            arr[i] = st.nextToken().charAt(0);
        }
        go(0, n,"", arr);
        Collections.sort(res);

        int m = res.size();
        System.out.println(res.get(m-1));
        System.out.println(res.get(0));

    }

    public static void go(int index, int n, String num, char[] arr){
        if(index == n+1){
            if(isOk(num, n,arr)) res.add(num);
            return;
        }

        for(int i = 0; i<=9; i++){
            if(v[i]) continue;
            v[i] = true;
            go(index+1, n,num + Integer.toString(i), arr);
            v[i] = false;
        }
    }

    public static boolean isOk(String num, int n, char[] arr){
        for(int i = 0; i<n; i++){
            if(arr[i] == '<'){
                if(num.charAt(i) > num.charAt(i+1)) return false;
            }else{
                if(num.charAt(i) < num.charAt(i+1)) return false;
            }
        }
        return true;
    }
}

/**
 *
 *
 *  123 => 3
 *
 */
