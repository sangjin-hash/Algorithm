import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int num = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while(n-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            int k;
            switch(command){
                case "add" :
                    k = Integer.parseInt(st.nextToken());
                    add(k);
                    break;
                case "check" :
                    k = Integer.parseInt(st.nextToken());
                    boolean flag = check(k);
                    if(flag) sb.append('1').append('\n');
                    else sb.append('0').append('\n');
                    break;
                case "remove" :
                    k = Integer.parseInt(st.nextToken());
                    remove(k);
                    break;
                case "toggle" :
                    k = Integer.parseInt(st.nextToken());
                    toggle(k);
                    break;
                case "all" :
                    all();
                    break;
                case "empty":
                    num = 0;
                    break;
            }
        }
        System.out.println(sb.toString());
    }
    public static void add(int k){
        num = num | (1 << k);
    }

    public static boolean check(int k){
        if((num & (1 << k)) == 1<<k) return true;
        else return false;
    }

    public static void remove(int k){
        /*
        ex.         1 1 0                  1 1 0
                  - 1 0 0      -> &~     & 0 1 1
                  =   1 0                    1 0
         */
        num = num & ~(1<<k);
    }

    public static void toggle(int k){
        num = num ^ (1<<k);
    }

    public static void all(){
        for(int i = 0; i<=20; i++){
            if(!check(i)) add(i);
        }
    }
}
