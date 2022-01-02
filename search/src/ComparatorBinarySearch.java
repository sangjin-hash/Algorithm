import java.util.Arrays;                     //Arrays.binarySearch()
import java.util.Scanner;
import java.util.Comparator;

class ComparatorBinarySearch {

    static class PhyscData{
        private String name;
        private int height;
        private double vision;

        public PhyscData(String name, int height, double vision){
            this.name = name; this.height = height; this.vision = vision;
        }

        public String toString(){
            return name + " " + height + " " + vision;
        }

        public static final Comparator<PhyscData> HEIGHT_ORDER = new HeightOrderComparator();

        private static class HeightOrderComparator implements Comparator<PhyscData>{

            @Override
            public int compare(PhyscData o1, PhyscData o2) {

                //검색한 key 값 > 기존 값 -> 1
                //검색한 key 값 < 기존 값 -> -1
                //검색한 key 값 == 기존 값 -> 0

                return (o1.height > o2.height) ? 1 :
                        (o1.height < o2.height) ? -1 : 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        PhyscData[] x = {
                new PhyscData("이나령", 162, 0.3),
                new PhyscData("유지훈", 168, 0.4),
                new PhyscData("김한결", 169, 0.8),
                new PhyscData("홍준기", 171, 1.5),
                new PhyscData("전서현", 173, 0.7),
                new PhyscData("이호연", 174, 1.2),
                new PhyscData("이수민", 175, 2.0),
        };

        System.out.print("몇 cm인 사람을 찾고 있나요? ");
        int height = stdIn.nextInt();

        //Arrays.binarySearch(배열, Object, Comparator) -> Comparator을 기준으로 배열 요소의 대소 관계를 판단하여 이진 검색 수행
        int idx = Arrays.binarySearch(x, new PhyscData("",height, 0.0),
                PhyscData.HEIGHT_ORDER);

        if(idx < 0)
            System.out.println("검색 실패");
        else{
            System.out.println("x[" + idx + "]에 있습니다");
            System.out.println("찾은 데이터 : "+x[idx]);
        }
    }
}
