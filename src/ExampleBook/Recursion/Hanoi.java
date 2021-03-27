package ExampleBook.Recursion;

import java.util.Scanner;

public class Hanoi {

    // no개의 원반을 x 번 기둥에서y번 기둥으로 옮김
    // 시작기둥 목표기둥 중간기둥
    public static void move(int no, int x, int y) {

        if (no > 1) {
            move(no - 1, x, 6 - x - y);
        }
        System.out.println("원반["+ no +"]"+x+"로부터"+y);

        if (no > 1) {
            move(no-1,6-x-y,y);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        move(n,1,3);
    }
}
