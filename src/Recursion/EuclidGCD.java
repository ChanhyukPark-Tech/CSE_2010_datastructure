package Recursion;

import java.util.Scanner;

public class EuclidGCD {
    public static int GCD(int x, int y) {
        if (y == 0) {
            return x;
        }
        return GCD(y , x % y);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("X : ");
        int x = in.nextInt();
        System.out.println("Y : ");
        int y = in.nextInt();

        int answer = GCD(x,y);

        System.out.println(answer);
    }
}
