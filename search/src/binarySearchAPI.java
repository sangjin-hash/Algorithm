import java.util.Arrays;                //Arrays.binarySearch method 이용
import java.util.Scanner;

class binarySearchAPI {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요소 개수 : ");
        int num = stdIn.nextInt();
        int[] x = new int[num];

        System.out.println("오름차순으로 입력하시오");

        System.out.print("x[0] : ");
        x[0] = stdIn.nextInt();

        //순차적으로 더 큰 값이 입력될때까지 반복
        for(int i = 1; i< num; i++){
            do{
                System.out.print("x["+i+"]: ");
                x[i] = stdIn.nextInt();
            }while(x[i] < x[i-1]);
        }

        System.out.print("검색할 값 : ");
        int ky = stdIn.nextInt();

        //parameter : 배열, key값
        int idx = Arrays.binarySearch(x,ky);

        if(idx == -1)
            System.out.println("검색 실패");
        else
            System.out.println(ky+"는 x["+idx+"]에 있습니다");
    }
}
