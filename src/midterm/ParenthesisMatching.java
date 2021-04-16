package midterm;

import java.util.Stack;

public class ParenthesisMatching {

    public static boolean isMatched(String expression) {
        final String opening = "({[";
        final String closing = ")}]";
        Stack<Character> buffer = new Stack<Character>();
        for (char c : expression.toCharArray()) {
            if (opening.indexOf(c) != -1) {                                                // this is a left delimiter

                buffer.push(c);
            }else if (closing.indexOf(c) != opening.indexOf(buffer.pop())){
                return false;
            }
        }
        return buffer.isEmpty();
    }

}
