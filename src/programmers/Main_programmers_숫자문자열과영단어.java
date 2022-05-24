package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_programmers_숫자문자열과영단어 {
    public static int solution(String s) {
        String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for(int i=0; i<numbers.length; i++){
            if(s.indexOf(numbers[i])!=-1){
                s = s.replaceAll(numbers[i], ""+i);
            }
        }

        int answer = Integer.parseInt(s);

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(solution(s));
    }
}
