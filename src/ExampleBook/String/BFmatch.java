package ExampleBook.String;


import java.util.Scanner;

public class BFmatch {

    static int bfMatch(String txt, String pat){
        int pt = 0;
        int pp = 0;

        while(pt != txt.length() && pp != pat.length()){
            if(txt.charAt(pt) == pat.charAt(pp)){
                pt++;
                pp++;
            }else{
                pt = pt - pp + 1;
                pp = 0;
            }
        }
        if(pp == pat.length()){
            return pt - pp;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("텍스트 : ");
        String s1 = in.next(); // 텍스트용 문자열

        System.out.println("패턴 : ");
        String s2 = in.next(); // 패턴용 문자열

        int idx = bfMatch(s1,s2);

        if(idx == -1){
            System.out.println("텍스트에 패턴이 없습니다");
        }else{
            //일치하는 문자 바로 앞까지의 길이를 구합니다
            int len = 0;
            for(int i = 0;i<idx;i++){
            }
        }
    }
}
