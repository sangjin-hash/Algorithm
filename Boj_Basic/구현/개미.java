import java.io.*;
import java.util.*;

class Node{
    char c;
    boolean team;

    public Node(char c, boolean team){
        this.c = c;
        this.team = team;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());

        ArrayList<Node> ants = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        String str1 = br.readLine();
        for(int i = n1-1; i>=0; i--){
            char c = str1.charAt(i);
            Node node = new Node(c, false);
            ants.add(node);
        }

        String str2 = br.readLine();
        for(int i = 0; i<n2; i++){
            char c = str2.charAt(i);
            Node node = new Node(c, true);
            ants.add(node);
        }

        int t = Integer.parseInt(br.readLine());

        if(n1+n2-1 <= t){
            StringBuilder temp_str = new StringBuilder();
            temp_str.append(str1);

            sb.append(str2).append(temp_str.reverse());
            System.out.print(sb);
            return;
        }

        while(t-- > 0){
            for(int i = 0; i<ants.size()-1; i++){
                Node cur = ants.get(i);
                Node next = ants.get(i+1);

                if(cur.team || cur.team == next.team) continue;

                ants.set(i, next);
                ants.set(i+1, cur);
                i++;
            }
        }

        for(int i = 0; i<ants.size(); i++){
            sb.append(ants.get(i).c);
        }
        System.out.println(sb);
    }
}

/**
 *  ant1 = ALJ  / ant2 = CRUO
 *  t = 0 -> ALJ CRUO
 *  t = 1 -> ALC JRUO
 *  t = 2 -> ACL RJUO
 *  t = 3 -> CAR LUJO
 *  t = 4 -> CRA ULOJ
 *  t = 5 -> CRU AOLJ
 *  t = 6 -> CRU OJLA
 *  종료
 *
 *  ant1 = CBA / ant2 = DEF
 *  t = 0 -> CBADEF
 *  t = 1 -> CBDAEF
 *  t = 2 -> CDBEAF
 *  t = 3 -> DCEBFA
 *  t = 4 -> DECFBA
 *  t = 5 -> DEFCBA
 *  종료
 */
