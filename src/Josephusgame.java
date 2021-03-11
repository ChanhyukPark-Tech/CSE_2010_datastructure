import java.util.LinkedList;
import java.util.Queue;

public class Josephusgame {

    public static int joseph(int n, int k){
        Queue q = new LinkedList();
        for(int i=1; i<=n;i++){
            q.offer(i);
        }
        System.out.println(q);
        while( q.size() > 1){
            for (int i=1 ; i<k;i++){
                q.offer(q.poll());
                System.out.println(q);

            }
            q.poll();
        }
        System.out.println(q);
        return (int) q.poll();
    }

    public static void main(String[] args){
        System.out.println(joseph(9,3));
    }
}
