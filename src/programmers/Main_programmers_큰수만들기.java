package programmers;

public class Main_programmers_큰수만들기 {
    static String answer = "0";

    public static void func(String number, String result, int k, int idx, int count) {
        if(count == k){
            if(idx<number.length())
                result += number.substring(idx);
            answer = Long.parseLong(answer)<Long.parseLong(result)? result : answer;
            return;
        } else if(idx >= number.length()) return;


        func(number, result, k, idx+1, count+1); // 빼는 경우
        func(number, result+number.charAt(idx), k, idx+1, count); // 빼지 않는 경우
    }

    public static String solution(String number, int k) {
        func(number, "", k, 0, 0);
        return answer;
    }

    public static void main(String[] args) {
        String number = "1231234";
        int k = 3;
        String answer = solution(number, k);
        System.out.println(answer);
    }
}
