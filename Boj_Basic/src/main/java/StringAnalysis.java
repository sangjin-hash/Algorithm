import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = "";
        while((str = br.readLine()) != null){
            int s_count = 0, b_count = 0;
            int d_count = 0, n_count = 0;
            for(int i = 0 ; i<str.length();i++){
                char c = str.charAt(i);
                if('a'<= c && c <= 'z') s_count+=1;
                else if('A' <= c && c<='Z') b_count +=1;
                else if(c == ' ') n_count +=1;
                else d_count+=1;
            }
            bw.write(s_count + " " + b_count + " " + d_count + " " + n_count + "\n");
            bw.flush();
        }
    }
}
