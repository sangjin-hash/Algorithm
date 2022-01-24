import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        for(int i = 0; i<str.length();i++){
            char c = str.charAt(i);
            if('a'<= c && c < 'n' || 'A' <= c && c < 'N') c += 13;
            else if('n' <= c && c <= 'z' || 'N' <= c && c <= 'Z') c -=13;
            bw.write(c);
        }
        bw.flush();
    }
}
