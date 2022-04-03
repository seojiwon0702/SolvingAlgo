package programmers;

public class Main_programmers_양궁대회 {
    static int MAX = 0;
    static int[] answer;

    public static void dfs(int[] lion, int[] apeach, int n, int lionScore, int apeachScore, int idx) {
        if (idx > 10) {
            lion[10] = n;
            if (lionScore - apeachScore > MAX) {
                MAX = lionScore - apeachScore;
                answer = lion.clone();
            } else if (MAX != 0 && lionScore - apeachScore == MAX) {
                for (int i = 10; i >= 0; i--) {
                    if (answer[i] < lion[i]) {
                        answer = lion.clone();
                        break;
                    } else if (answer[i] > lion[i])
                        break;
                }
            }
            return;
        } else {
            if (n > apeach[idx]) { // 이기는 경우
                lion[idx] = apeach[idx] + 1;
                dfs(lion, apeach, n - (apeach[idx] + 1), lionScore + (10 - idx), apeachScore, idx + 1);
            }
            lion[idx] = 0;
            if(apeach[idx]>0)
                dfs(lion, apeach, n, lionScore, apeachScore + (10 - idx), idx + 1);
            else dfs(lion, apeach, n, lionScore, apeachScore, idx+1);
        }
    }

    public static int[] solution(int n, int[] info) {
        int[] lion = new int[11];
        dfs(lion, info, n, 0, 0, 0);
        return MAX > 0 ? answer : new int[]{-1};
    }

    public static void main(String[] args) {
        int[] result = solution(5, new int[]{2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0});
        for (int n : result)
            System.out.print(n + " ");
        System.out.println();
    }
}
