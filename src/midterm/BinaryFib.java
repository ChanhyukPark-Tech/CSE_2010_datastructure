package midterm;
class Pair{
    private int i ;
    private int j ;

    public Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "i=" + i +
                ", j=" + j +
                '}';
    }

    public void setJ(int j) {
        this.j = j;
    }
}
public class BinaryFib {

    public static int binaryFib(int n) {
        if (n <= 1) {
            return n;
        }
        return binaryFib(n - 2) + binaryFib(n - 1);
    }

    public static Pair binaryFib_better(int n){
        if(n <= 1){
            return new Pair(n,0);
        }else{
            Pair pair = binaryFib_better(n-1);
            return new Pair(pair.getI()+ pair.getJ(), pair.getI());
        }
    }

    public static Pair binaryFib_professor(int n ){
        if (n <= 1) {
            return new Pair(n,0);
        }
        else{
            Pair pair = binaryFib_professor(n-1);
            int i = pair.getI();
            int j = pair.getJ();
            return new Pair(i+j, i);
        }
    }
    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            Pair answer = binaryFib_better(i);

            System.out.println(answer);
        }
    }
}
