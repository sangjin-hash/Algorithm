import java.util.Scanner;

public class Stack {
    private int max;            //스택 용량
    private int ptr;            //stack pointer
    private int[] stk;          //stack

    // 실행 시 예외 : 스택이 비어있음
    public class EmptyIntStackException extends RuntimeException{
        public EmptyIntStackException(){ }
    }

    // 실행 시 예외 : 스택이 가득 참
    public class OverflowIntStackException extends RuntimeException{
        public OverflowIntStackException() { }
    }

    public Stack(int capacity){
        ptr = 0;
        max = capacity;
        try{
            stk = new int[max];
        } catch(OutOfMemoryError e){
            max = 0;
        }
    }

    // 스택에 x를 푸시
    public int push(int x) throws OverflowIntStackException{
        if(ptr >= max)      //overflow 발생
            throw new OverflowIntStackException();
        return stk[ptr++] = x;
    }

    // 스택에서 데이터를 pop
    public int pop() throws EmptyIntStackException{
        if(ptr <= 0)
            throw new EmptyIntStackException();
        return stk[--ptr];
    }

    // 꼭대기의 data를 read만 함
    public int peek() throws EmptyIntStackException{
        if(ptr <= 0)
            throw new EmptyIntStackException();
        return stk[ptr-1];
    }

    // stack에서 x를 search (꼭대기 -> 바닥 traverse)
    public int indexOf(int x){
        for(int i = ptr - 1; i>=0; i--)
            if(stk[i] == x)
                return i;
        return -1;
    }

    public void clear(){
        ptr = 0;
    }

    public int capacity(){
        return max;
    }

    public int size(){
        return ptr;
    }

    public boolean isEmpty(){
        return ptr <= 0;
    }

    public boolean isFull(){
        return ptr >= max;
    }

    // 스택 안의 모든 데이터를 바닥 -> 꼭대기 순으로 출력
    public void dump(){
        if(ptr <= 0)
            System.out.println("스택이 비어 있습니다");
        else{
            for(int i = 0; i<ptr; i++)
                System.out.print(stk[i]+ " ");
            System.out.println();
        }
    }
}