import java.util.Scanner;

public class Polynomial {


    /**
     * @param coefficients
     * @param x
     * @param n
     * @return
     */
    public static int polynomial(int[] coefficients, int x, int n) {
        int answer = 0;                             // 정답을 초기화

        for (int i = 0; i < n; i++) {               // 0 부터 n-1 까지 돌면서 answer 에 지속적으로 + 계수*x^i 를 해준다.
            answer = answer + coefficients[n - (i + 1)] * power(x, i);
        }
        return answer;
    }


    // int 변수 x 와 y 를 받아서 x^y 를 계산하여 int 로 return 해주는 private method        2016005387 박찬혁
    private static int power(int x, int y) {
        // return 1 if y= 0 example == > 3^0 = 1
        if (y == 0) {
            return 1;
        } else {
            int answer = 1;
            for (int i = 1; i <= y; i++) {
                answer = answer * x;
            }
            return answer;
        }
    }

    // using recursion make time complexity O(log n)            //2016005387 박찬혁
    // method call itself
    private static double power_binary(int x, int y) {
        if (y == 0) {
            return 1;
        }

        double temp = power_binary(x, y / 2);

        if (y % 2 == 0) {
            return temp * temp;
        } else {
            if (y > 0) {
                return x * temp * temp;
            } else {
                return (temp * temp) / x;
            }
        }
    }

    public static void main(String[] args) {
        /**
         Scanner in = new Scanner(System.in);
         System.out.println("Enter the number of terms in polynomial");
         int n = in.nextInt();
         int[] poly = new int[n];
         System.out.println("Enter the coefficients of polynomial");

         for (int i = 0; i < n; i++) {
         poly[i] = in.nextInt();
         }

         System.out.println("Enter value of x for polynomial");
         for (int x = 0; x < 100; x++) {
         System.out.println("Value of polynomial is   == > " + polynomial(poly, x, n));
         */

        float x = 3;
        float y = 4;
        System.out.println(x / y);
    }
}

