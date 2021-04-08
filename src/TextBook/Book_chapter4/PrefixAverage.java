package TextBook.Book_chapter4;

import java.util.Arrays;

public class PrefixAverage {

    public static double[] prefixAverage1(double[] x) {
        int n = x.length;
        double[] a = new double[n];
        for (int j = 0; j < n; j++) {
            double total = 0 ;
            for(int i =0 ; i<= j ; i++){
                total += x[i];
            }
            a[j] = total /(j+1);
        }
        return a;
    }

    public static double[] prefixAverage2(double[] x ){
        int n = x.length;
        double[] a = new double[n];
        double total = 0 ;
        for(int i = 0 ; i < n ; i++){
            total += x[i];
            a[i] = total / (i+1);
        }
        return a;

    }

    public static void main(String[] args) {
        double[] test = {3,42,4,24,2,52,3,52,321,5,45,436,3,6,36,3,635};
        double[] answer = prefixAverage2(test);
        System.out.println(Arrays.toString(answer));
    }
}
