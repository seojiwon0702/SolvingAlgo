package programmers;

import java.util.ArrayList;

public class Main_programmers_문자열압축 {

    private static int solution(String s){
        int answer = 0;
        int stringLength = s.length();
        int shortest = stringLength;

        for (int i = 1; i <= stringLength/2; i++) { // 문자 몇개를 기준으로 자를 것인가
            String temp = ""; // 압축된 문자열 저장
            int count = 1; // 같은 문자 반복횟수 저장
            String nowWords = "";
            int lastIdx = 0;

            while(nowWords.length() < i) nowWords += s.charAt(lastIdx++);
            while(lastIdx < stringLength) {
                if (stringLength - lastIdx < i) {
                    for (int j = lastIdx; j < stringLength; j++) {
                        temp += s.charAt(j);
                    }
                    break;
                }
                String nextWords = "";
                while (nextWords.length() < i) nextWords += s.charAt(lastIdx++);
                if (nowWords.equals(nextWords)) {
                    count++;
                    continue;
                } else {
                    if (count > 1) temp += count;
                    for (int j = 0; j < nowWords.length(); j++) temp += nowWords.charAt(j);
                    nowWords = nextWords;
                    count = 1;
                }
            }

                if(count>1) temp += count;
                for(int j=0; j<nowWords.length(); j++) temp += nowWords.charAt(j);
                if(temp.length() < shortest) shortest = temp.length();
        }
        answer = shortest;
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("aabbaccc"));
    }
}
