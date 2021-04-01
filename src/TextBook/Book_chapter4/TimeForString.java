package TextBook.Book_chapter4;

public class TimeForString {

    public static String repeat1(char c , int n){
        String answer = "";
        for(int j=0;j<n;j++){
            answer += c;
        }
        return answer;
    }

    public static String repeat2(char c , int n ){
        StringBuilder sb = new StringBuilder();
        for(int j=0; j<n;j++){
            sb.append(c);
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        double r1_start = System.currentTimeMillis();
        repeat1('*',300000);
        double r1_final = System.currentTimeMillis();
        double r1_answer = r1_final - r1_start;
        System.out.println(r1_answer);
        double r2_start = System.currentTimeMillis();
        repeat2('*',300000);
        double r2_final = System.currentTimeMillis();
        double r2_anwser = r2_final - r2_start;
        System.out.println(r2_anwser);
    }
}
