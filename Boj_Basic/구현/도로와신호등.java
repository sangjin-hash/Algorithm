import java.io.*;
import java.util.*;

class Node{
    int location;
    int r;
    int g;

    Node(int location, int r, int g){
        this.location = location;
        this.r = r;
        this.g = g;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        ArrayList<Node> list = new ArrayList<>();

        int n = Integer.parseInt(st1.nextToken());
        int l = Integer.parseInt(st1.nextToken());
        int time = 0;

        //출발지점
        Node start = new Node(0,0,0);
        list.add(start);

        for(int i = 0; i<n; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            int location = Integer.parseInt(st2.nextToken());
            int r = Integer.parseInt(st2.nextToken());
            int g = Integer.parseInt(st2.nextToken());

            Node node = new Node(location, r, g);
            list.add(node);
        }

        //도착지점
        Node end = new Node(l,0,0);
        list.add(end);

        for(int i = 0; i< list.size()-1; i++){
            Node cur = list.get(i);
            Node next = list.get(i+1);

            time += next.location - cur.location;

            if(next.r == 0 && next.g == 0) continue;

            int cycle = next.r + next.g;
            int sign = time % cycle;

            if(sign < next.r){
                time += next.r - sign;
            }
        }
        System.out.println(time);
    }
}

/**
 *
 */
