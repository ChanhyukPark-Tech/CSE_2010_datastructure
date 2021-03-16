package Array;

public class MultipleArrayCloneTest {
    public static void main(String[] args) {
        int[][] a = {{1, 2, 3, 4}, {5, 67, 8}};
        int[][] b = a.clone();

        System.out.println(b[0].length);
    }
}
