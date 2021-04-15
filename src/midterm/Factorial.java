package midterm;

public class Factorial {

    public static int factorial(int n ){
        if(n == 0){
            return 1 ;
        }
        return n * factorial(n-1);
    }

    public static int factorial_tail(int n , int result){
        if(n <= 1){
            return result;
        }

        return factorial_tail(n-1 , result * n);
    }

    public static void main(String[] args) {
//        int answer = factorial(6);
        int answer = factorial_tail(5,1);
        System.out.println(answer);
    }

}
