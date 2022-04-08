package programmers;

public class Main_programmers_모음사전 {
    // A,E,I,O,U

    public static int solution(String word) {
        char[] chars = {'A','E','I', 'O', 'U'};
        int answer = 0;

        for(int i = 0; i<word.length(); i++){
            if(word.charAt(i) == 'A')
                answer += 1;
            else {
                int idx = 0;
                while(chars[idx] != word.charAt(i)) {
                    answer += Math.pow(5, 4-i);
                    for (int j = 0; j < 4-i; j++)
                        answer += Math.pow(5, j);
                    idx++;
                }
                answer += 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("EIO"));
    }
}
