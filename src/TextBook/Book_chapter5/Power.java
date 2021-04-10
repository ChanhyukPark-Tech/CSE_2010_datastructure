package TextBook.Book_chapter5;

public class Power {

    public static double power(double x, int n) {
        if (n == 0) {
            return 1;

        } else {
            return x * power(x, n - 1);
        }
    }
}
