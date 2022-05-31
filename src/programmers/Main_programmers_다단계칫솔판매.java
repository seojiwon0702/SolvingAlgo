package programmers;

import java.util.HashMap;

public class Main_programmers_다단계칫솔판매 {
    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];

        HashMap<String, String> pair = new HashMap<>();
        HashMap<String, Integer> incomeMap = new HashMap<>();

        for (int i = 0; i < enroll.length; i++) {
            pair.put(enroll[i], referral[i]);
            incomeMap.put(enroll[i], 0);
        }

        for (int i = 0; i < amount.length; i++) {
            String sellerName = seller[i];
            int income = amount[i] * 100;

            while (true) {
                if (income / 10 < 1) {
                    incomeMap.put(sellerName, incomeMap.get(sellerName) + income);
                    break;
                } else {
                    incomeMap.put(sellerName, incomeMap.get(sellerName) + income - income / 10);
                    if (pair.get(sellerName).equals("-")) break;
                    income /= 10;
                    sellerName = pair.get(sellerName);
                }
            }

        }

        for (int i = 0; i < enroll.length; i++) {
            answer[i] = incomeMap.get(enroll[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"sam", "emily", "jaimie", "edward"};
        int[] amount = {2, 3, 5, 4};
        int[] answer = solution(enroll, referral, seller, amount);

        for (int n : answer)
            System.out.print(n + " ");
        System.out.println();
    }
}
