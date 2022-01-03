public class Queue {
    private int max;            // 큐의 용량
    private int front;          // 첫 번째 요소 커서
    private int rear;           // 마지막 요소 커서
    private int num;            // 현재 데이터 수
    private int[] que;

    public class EmptyIntQueueException extends RuntimeException{
        public EmptyIntQueueException() { }
    }

    public class OverflowIntQueueException extends RuntimeException{
        public OverflowIntQueueException() { }
    }

    public Queue(int capacity){
        num = front = rear = 0;
        max = capacity;
        try{
            que = new int[max];
        } catch(OutOfMemoryError e){
            max = 0;
        }
    }

    // data를 넣고, rear를 1 증가시키면서 rear는 그 다음에 넣을 idx를 가리킨다.
    public int enque(int x) throws Stack.OverflowIntStackException{
        if(num >= max)
            throw new OverflowIntQueueException();
        que[rear++] = x;
        num++;
        if(rear == max) //rear가 큐의 최대 용량인 max와 같아질 경우 rear를 배열의 처음인 0으로 변경
            rear = 0;
        return x;
    }

    // enque와 반대로 data를 꺼내고 front를 1 증가시키면서 그 다음에 뺄 idx를 가리킨다.
    public int deque() throws EmptyIntQueueException{
        if(num <= 0)
            throw new EmptyIntQueueException();
        int x = que[front++];
        num--;
        if(front == max)
            front = 0;
        return x;
    }

    public int peek() throws EmptyIntQueueException{
        if(num <= 0)
            throw new EmptyIntQueueException();
        return que[front];
    }

    public int indexOf(int x){
        for(int i = 0; i<num; i++){
            int idx = (i + front) % max;
            if(que[idx] == x)
                return idx;
        }
        return -1;
    }

    public void clear(){
        num = front = rear = 0;
    }

    public int capacity(){
        return max;
    }

    public int size(){
        return num;
    }

    public boolean isEmpty(){
        return num <= 0;
    }

    public boolean isFull(){
        return num >= max;
    }

    public void dump(){
        if(num <= 0)
            System.out.println("큐가 비어있습니다");
        else{
            for(int i = 0; i<num; i++)
                System.out.println(que[(i+front) % max] + " ");
            System.out.println();
        }
    }

}