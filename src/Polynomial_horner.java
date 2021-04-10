public class Polynomial_horner {                //2016005387 박찬혁

    public static int horner(int coefficients[], int x, int n) {
        int result = coefficients[0];

        for (int i = 1; i < n; i++) {
            result = result * x + coefficients[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] coefficients = {1,2,3,4};
        int answer = horner(coefficients,4,4);
        System.out.println(answer);
    }
}
