package Stack;

import java.util.Scanner;

public class IntStack {
    private int max;// 스택 용량
    private int ptr; // 스택 포인터
    private int[] stk; // 스택 본체

    //실행시 예외 : 스택이 비어있음

    public class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() {
        }
    }

    public class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() {

        }
    }

    public int push(int x) throws OverflowIntStackException {
        if (ptr >= max) {
            throw new OverflowIntStackException();
        }
        return stk[ptr++] = x;
    }

    public int pop() throws EmptyIntStackException {
        if (ptr <= 0) {
            throw new EmptyIntStackException();
        }
        return stk[--ptr];
    }

    // 스택에서 데이터를 피크(정상에 있는 데이터를 들여다봄)
    // 데이터의 입력과 출입이 없으므로 스택 포인터는 변화하지 않습니다.
    public int peek() throws EmptyIntStackException {
        if (ptr <= 0) {
            throw new EmptyIntStackException();
        }
        return stk[ptr - 1];
    }

    public int indexOf(int x) {
        for (int i = ptr - 1; i <= 0; i--) {
            if (stk[i] == x) {
                return i;
            }
        }
        return -1;
    }

    //스택의 모든 요소를 삭제하는 메서드 clear
    // clear 메서드는 스택에 쌓여있는 모든 데이터를 삭제하는 메서드입니다.
    // 스택에 대한 푸시와 팝 등 모든 작업은 스택 포인터를 바탕으로 이루어집니다. 따라서 스택의 배열 요솟값을 변경할 필요가 없습니다. 모든 요소의 삭제는 스택 포인터 ptr 값을 0 으로 하면 끝납니다.
    public void clear() {
        ptr = 0;
    }

    // 스택의 용량을 반환
    public int capacity() {
        return max;
    }

    public int size() {
        return ptr;
    }

    public boolean isEmpty() {
        return ptr == 0;
    }

    public boolean isFull() {
        return ptr >= max;
    }

    // 스택 안의 모든 데이터를 바닥 ----- > 꼭대기 순서로 출력

    public void dump() {
        if (ptr <= 0) {
            System.out.println("스택이 비어있습니다.");
        } else {
            for (int i = 0; i < ptr; i++) {
                System.out.print(stk[i]);
            }

        }
    }

    public IntStack(int capacity) {
        ptr = 0;
        max = capacity;
        try {
            stk = new int[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        IntStack s = new IntStack(64); // 최대 64개를 푸시할 수 있는 스택

        while(true){
            System.out.println("현재 데이터수 : " + s.size() + "/" + s.capacity());
            System.out.print("(1)푸시 (2)팝 (3)피크 (4)덤프 (0)종료");

            int menu = in.nextInt();
            if(menu == 0){break;}

            int x;
            switch (menu) {
                case 1: {
                    System.out.print("데이터 :");
                    x = in.nextInt();
                    try {
                        s.push(x);
                    } catch (IntStack.OverflowIntStackException e) {
                        System.out.println("스택이 가득 찼습니다.");
                    }
                    break;
                }

                case 2: {
                    try{
                        x = s.pop();
                        System.out.println("팝한 데이터는 " + x + " 입니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어있습니다.");
                    }
                    break;
                }

                case 3: {                       //피크
                    try{
                        x = s.peek();
                        System.out.println("피크한 데이터는 " + x + "입니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어있습니다.");
                    }
                    break;
                }

                case 4: {
                    s.dump();
                    break;
                }
            }
        }
    }
}
