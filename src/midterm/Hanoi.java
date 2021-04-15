package midterm;

public class Hanoi {

    public static void move(int disk , char source , char dest , char aux){
        if (disk > 0) {
            move(disk-1 , source , aux , dest);
            System.out.println("move from " + source + " to " + dest);
            move(disk-1,aux,dest,source);
        }


    }

    public static void main(String[] args) {
        move(5,'a','b','c');
    }
}
