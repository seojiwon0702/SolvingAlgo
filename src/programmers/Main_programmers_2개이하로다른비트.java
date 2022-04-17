package programmers;

public class Main_programmers_2개이하로다른비트 {
    public static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) // 짝수의 경우 +1만 해주면 해결
                answer[i] = numbers[i] + 1;
            else { // 홀수의 경우 0을 포함하는지 하지 않는지 다르게 해결
                String number = Long.toBinaryString(numbers[i]);
                if (number.contains("0")) { // 0을 포함하는 경우
                    int lastIdxOfZero = number.lastIndexOf("0");
                    String result = "";
                    result += number.substring(0, lastIdxOfZero);
                    result += "10";
                    result += number.substring(lastIdxOfZero+2);
                    answer[i] = Long.parseLong(result, 2);
                } else { // 0을 포함하지 않는 경우
                    String result = "10";
                    result += number.substring(1);
                    answer[i] = Long.parseLong(result, 2);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        long[] numbers = new long[]{2, 7};
        long[] answer = solution(numbers);
        for (long l : answer) {
            System.out.print(l + " ");
        }
        System.out.println();
    }
}
