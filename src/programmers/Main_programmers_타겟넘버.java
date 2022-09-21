package programmers;

public class Main_programmers_타겟넘버 {

    public static int calcul(int[] numbers, int target, int idx, int result){
        if(idx == numbers.length){
            if(result == target) return 1;
            else return 0;
        }
        int answer = 0;

        answer += calcul(numbers, target, idx+1, result+numbers[idx]);
        answer += calcul(numbers, target, idx+1, result-numbers[idx]);

        return answer;
    }

    public static int solution(int[] numbers, int target) {
        int answer = 0;

        answer = calcul(numbers, target, 0, 0);

        return answer;
    }

    public static void main(String[] args) {
        int answer = solution(new int[]{4,1,2,1}, 4);
        System.out.println(answer);
    }
}
