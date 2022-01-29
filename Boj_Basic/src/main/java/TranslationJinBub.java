import java.io.*;
import java.util.*;

public class Main{

    public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		String str = st.nextToken();
		int B = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder(str);
		String reverse = sb.reverse().toString();
		int num = 0;
		
		for(int i = 0; i<reverse.length(); i++){
				if(reverse.charAt(i) >= 'A'){
          //'7' ASCII = 55
					num += (reverse.charAt(i)-'7')*(int)Math.pow(B,i);
				}	
				else{
					num += (reverse.charAt(i)-'0')*(int)Math.pow(B,i);
				}
				
		}
		System.out.println(num);	
		
		
	}
}
