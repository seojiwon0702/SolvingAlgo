package programmers;

public class Main_programmers_JadenCase문자열만들기 {
    public static String solution(String s) {
        String answer = "";
        s = s.toLowerCase();

        boolean flag = true;

        for(int i=0; i<s.length(); i++){

            if(flag && s.charAt(i)>95 && s.charAt(i) < 123){
                answer += (char)(s.charAt(i) - 32);
            }
            else
                answer += s.charAt(i);

            flag = s.charAt(i) == ' '? true : false;
        }

        return answer;
    }

    public static void main(String[] args) {
        String answer = solution("3people unFollowed me");
        System.out.println(answer);
    }
}
