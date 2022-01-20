import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int M = Integer.parseInt(br.readLine());

        Stack<String> leftSt = new Stack<>();
        Stack<String> rightSt = new Stack<>();

        String[] arr = str.split("");
        for(String s : arr)
            leftSt.push(s);

        while(M-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            switch(st.nextToken()){
                case "L":
                    if(!leftSt.isEmpty())
                       rightSt.push(leftSt.pop());
                    break;

                case "D":
                    if(!rightSt.isEmpty())
                        leftSt.push(rightSt.pop());
                    break;
                case "B":
                    if(!leftSt.isEmpty())
                        leftSt.pop();
                    break;
                case "P":
                    leftSt.push(st.nextToken());
                    break;
            }
        }

        while(!leftSt.isEmpty())
            rightSt.push(leftSt.pop());
        while(!rightSt.isEmpty())
            bw.write(rightSt.pop());

        bw.flush();
        bw.close();
    }
}

