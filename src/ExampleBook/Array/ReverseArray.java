package ExampleBook.Array;

import java.util.Random;
import java.util.Scanner;

public class ReverseArray {
    static void swap(int[] a, int idx1, int idx2) {
        int temp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = temp;
    }

    static void reverse(int[] a) {
        for (int i = 0; i < a.length / 2; i++) {
            swap(a, i, a.length - i - 1);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("요솟수 : ");
        int num = in.nextInt();

        int[] x = new int[num];

        for(int i=0;i<num;i++){
            x[i] = rand.nextInt(35);
            System.out.print(x[i]);
        }
        System.out.print("\n==== \n");
        reverse(x);

        for(int i=0; i<num;i++){
            System.out.print(x[i] + " ");
        }

    }


}
