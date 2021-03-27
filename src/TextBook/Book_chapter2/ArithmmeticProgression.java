package TextBook.Book_chapter2;

public class ArithmmeticProgression extends Progression{

    protected long increment;

    public ArithmmeticProgression(){
        this(1,0);
    }
    public ArithmmeticProgression(long stepsize){
        this(stepsize, 0);
    }

    public ArithmmeticProgression(long stepsize , long start){
        super(start);
        this.increment = stepsize;
    }

    protected void advance(){
        current += increment;
    }
}
