package Search;

public class BinSearch {
    public static int binsearch(int[] a, int n, int key) {
        int pl = 0;
        int pr = n - 1;
        while (pl <= pr) {
            int pc = (pl + pr) / 2;

            if (a[pc] == key) {
                return pc;
            } else if (a[pc] < key) {
                pl = pc + 1;
            } else if (a[pc] > key){
                pr = pc - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] x = {5,7,15,28,29,31,39,58,68,70,95};
        int answer = binsearch(x,x.length,6);
        System.out.println(answer);
    }
}
