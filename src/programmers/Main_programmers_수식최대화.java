package programmers;

import java.util.ArrayList;

public class Main_programmers_수식최대화 {
    public static long calculation(String[] operation, ArrayList<String> exp){
        for(int i=0; i<operation.length; i++){
            while(true){
                int idx = exp.indexOf(operation[i]);
                if(idx == -1) break;
                long temp = 0;
                switch(operation[i]){
                    case "+":
                        temp = Long.parseLong(exp.get(idx-1)) + Long.parseLong(exp.get(idx+1));
                        break;
                    case "-":
                        temp = Long.parseLong(exp.get(idx-1)) - Long.parseLong(exp.get(idx+1));
                        break;
                    case "*":
                        temp = Long.parseLong(exp.get(idx-1)) * Long.parseLong(exp.get(idx+1));
                        break;
                }
                exp.add(idx-1, String.valueOf(temp));
                exp.remove(idx+2);
                exp.remove(idx+1);
                exp.remove(idx);
            }
        }

        return Long.parseLong(exp.get(0));
    }

    public static ArrayList<String> tokenizer(String expression){
        ArrayList<String> result = new ArrayList<>();

        String temp = "";
        for(int i=0; i<expression.length(); i++){
            if(expression.charAt(i)=='+' || expression.charAt(i)=='-' || expression.charAt(i)=='*'){
                result.add(temp);
                result.add(String.valueOf(expression.charAt(i)));
                temp = "";
            } else{
                temp += expression.charAt(i);
            }
        }
        result.add(temp);

        return result;
    }

    public static long solution(String expression) {
        long answer = Long.MIN_VALUE;
        ArrayList<String> exp = tokenizer(expression);
        String[][] operations = {{"+", "-", "*"},{"-", "+", "*"},{"+", "*", "-"},{"-", "*", "+"},{"*", "-", "+"},{"*", "+", "-"}};

        for(String[] operation : operations){
            long result = calculation(operation, (ArrayList<String>) exp.clone());
            result = Math.abs(result);
            if(result>answer) answer= result;
        }
        return answer;
    }

    public static void main(String[] args) {
        String expression = "100-200*300-500+20";
        long answer = solution(expression);
        System.out.println(answer);
    }
}
