import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        char[] king = st.nextToken().toCharArray();
        char[] rock = st.nextToken().toCharArray();
        int n = Integer.parseInt(st.nextToken());

        while(n-- > 0){
            String cmd = br.readLine();
            char[] next_king = move(king, cmd);
            if(isRange(next_king)){
                if(next_king[0] == rock[0] && next_king[1] == rock[1]){
                    // 킹을 움직였더니 돌이랑 겹칠 때
                    char[] next_rock = move(rock, cmd);
                    if(isRange(next_rock)){
                        king = next_king;
                        rock = next_rock;
                    }
                    else continue;
                }else{
                    king = next_king;
                }
            }else continue;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(king[0]).append(king[1]).append('\n');
        sb.append(rock[0]).append(rock[1]);
        System.out.println(sb);
    }

    private static boolean isRange(char[] king){
        if(king[0] < 'A' || king[0] > 'H' ||
                '1' > king[1] || king[1] > '8'){
            return false;
        }else return true;
    }

    private static char[] move(char[] king, String cmd) {
        char[] next_king = king.clone();
        switch(cmd){
            case "R" :
                next_king[0]++;
                break;
            case "L" :
                next_king[0]--;
                break;
            case "B" :
                next_king[1]--;
                break;
            case "T" :
                next_king[1]++;
                break;
            case "RT" :
                next_king[0]++;
                next_king[1]++;
                break;
            case "LT" :
                next_king[0]--;
                next_king[1]++;
                break;
            case "RB" :
                next_king[0]++;
                next_king[1]--;
                break;
            case "LB" :
                next_king[0]--;
                next_king[1]--;
                break;
        }
        return next_king;
    }
}

/**
 *
 */
