package TextBook.Book_chapter2;

public class Progression {

    //instance variable
    protected long current;

    // Constructs a progrssion starting at zero

    public Progression() {
        this(0);
    }

    public Progression(long start) {
        current = start;
    }

    public long nextValue(){
        long answer = current;
        advance();
        return answer;
    }

    protected void advance(){
        current++;
    }

    public void printProgression(int n){
        System.out.println(nextValue());
        for(int j=1;j<n;j++){
            System.out.println(" " + nextValue());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Progression p1 = new Progression();
        p1.advance();
        p1.printProgression(10);
    }

}
