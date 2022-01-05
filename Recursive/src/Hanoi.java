import java.util.Scanner;

public class Hanoi {
    // no : 옮겨야 할 원반의 개수, x : 시작 기둥의 번호, y : 목표 기둥의 번호
    static void move(int no, int x, int y){
        // 6 - x - y => 기둥이 1,2,3이고, 기둥 번호의 합이 6이므로 6-x-y를 통해 중간 기둥 모두 구할 수 있다.
        if(no > 1)
            move(no -1, x, 6-x-y);

        System.out.println("원반["+no+"]을 "+x+"기둥에서 "+y+"기둥으로 옮김");

        if(no > 1)
            move(no-1, 6-x-y, y);
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("하노이 탑");
        System.out.print("원반 개수 : ");
        int n = stdIn.nextInt();

        move(n,1,3);
    }
}
