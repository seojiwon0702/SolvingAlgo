package programmers;

import java.util.Stack;

public class Main_programmers_올바른괄호 {
    static boolean solution(String s) {
        Stack<Character> bracket = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                bracket.push(s.charAt(i));
            } else {
                if(!bracket.isEmpty() && bracket.peek()=='(')
                    bracket.pop();
                else return false;
            }
        }

        if(!bracket.isEmpty())
            return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution("(())()"));
    }
}
