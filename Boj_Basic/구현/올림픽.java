import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    int team;
    int gold;
    int silver;
    int bronze;
    int rate;

    Node(int team, int gold, int silver, int bronze, int rate){
        this.team = team;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
        this.rate = rate;
    }

    @Override
    public int compareTo(Node o) {
        /*
        if(this.gold > o.gold){
            return -1;
        }else if(this.gold < o.gold){
            return 1;
        }else{
            if(this.silver > o.silver){
                return -1;
            }else if(this.silver < o.silver){
                return 1;
            }else{
                if(this.bronze > o.bronze){
                    return -1;
                }else if(this.bronze < o.bronze){
                    return 1;
                }else{
                    return 0;
                }
            }
        }
        */
        if(this.gold == o.gold){
            if(this.silver == o.silver){
                return o.bronze - this.bronze;
            }else{
                return o.silver - this.silver;
            }
        }
        else{
            return o.gold - this.gold;
        }
    }
}


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        ArrayList<Node> list = new ArrayList<>();

        while(n-- > 0){
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            int team = Integer.parseInt(st1.nextToken());
            int gold = Integer.parseInt(st1.nextToken());
            int silver = Integer.parseInt(st1.nextToken());
            int bronze = Integer.parseInt(st1.nextToken());

            Node node = new Node(team, gold, silver, bronze,1);
            list.add(node);
        }

        Collections.sort(list);
        for(int i = 1; i<list.size(); i++){
            int cur_gold = list.get(i).gold;
            int prev_gold = list.get(i-1).gold;

            int cur_silver = list.get(i).silver;
            int prev_silver = list.get(i-1).silver;

            int cur_bronze = list.get(i).bronze;
            int prev_bronze = list.get(i-1).bronze;

            if(cur_gold == prev_gold && cur_silver == prev_silver
                        && cur_bronze == prev_bronze){
                list.get(i).rate = list.get(i-1).rate;
            }else{
                list.get(i).rate = i+1;
            }
        }

        for(int i = 0; i<list.size(); i++){
            if(list.get(i).team == k){
                System.out.println(list.get(i).rate);
                break;
            }
        }
    }
}

/**
 *
 */
