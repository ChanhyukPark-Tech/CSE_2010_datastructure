package Search;

public class SeqSearch {

    public static int seqSearch(int[] a, int n, int key) {

        for (int i = 0; i < n; i++) {
            if (a[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] x = {2, 5, 6, 26, 6, 23645, 36, 26, 26, 26, 25, 2, 5,};
        int ky = 0;

        int index = seqSearch(x, x.length, ky);
        System.out.println(index);
    }
}
