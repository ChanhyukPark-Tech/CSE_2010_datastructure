package midterm;

import java.util.Stack;

public class Palindrome {


    public static boolean palindrome(String str){

        Stack<Character> stack = new Stack<Character>();                // wrapper class
        int length = str.length();
        int half = length / 2;

        for(int i = 0 ; i < half ; i++){
            stack.push(str.charAt(i));
            System.out.println(stack);
        }
        for(int i = half+1; i < str.length(); i++){
            if(stack.pop() != str.charAt(i)){
                return false;
            }
            System.out.println(stack);

        }
        if (!stack.isEmpty()) {
            return false;
        }

        return true;



    }

    public static void main(String[] args) {
        String str = "aabbccdccbbaa";
        Palindrome.palindrome(str);
        System.out.println(Palindrome.palindrome(str));
    }

}
