package intro_01;

public class Util {

    public static long timeIt(Runnable code){
        long start = System.nanoTime();
        code.run();
        return System.nanoTime() - start;
    }
}
