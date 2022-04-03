package programmers;

public class Main_programmers_양궁대회 {
    static int[] answer = new int[11];
    static int MAX = 0;

    public static void dfs(int[] lion, int[] apeach, int scoreLion, int scoreApeach, int idx, int n){
        if(idx==10){
            if(scoreLion - scoreApeach >= MAX){
                lion[idx] = n;
                if(MAX < (scoreLion-scoreApeach)){
                    MAX = scoreLion-scoreApeach;
                    answer = lion.clone();
                } else if(MAX == (scoreLion-scoreApeach)){
                    for(int i=10; i>=0; i--){
                        if(answer[i] < lion[i]) {
                            answer = lion.clone();
                            break;
                        }
                        else if(answer[i] == lion[i]) continue;
                        else break;
                    }
                }
            }
        }
        else {
            if(n>apeach[idx]) {
                lion[idx] = apeach[idx] + 1;
                dfs(lion, apeach, scoreLion + (10 - idx), scoreApeach, idx + 1, n - lion[idx]);
            }

            lion[idx] = 0;
            dfs(lion, apeach, scoreLion, scoreApeach + (10 - idx), idx + 1, n);
        }
    }

    public static int[] solution(int n, int[] info) {
        dfs(new int[11], info, 0, 0, 0, n);
        return MAX>0? answer:new int[]{-1};
    }

    public static void main(String[] args) {
        int[] result = solution(5, new int[]{2,1,1,1,0,0,0,0,0,0,0});
        for(int n : result)
            System.out.print(n + " ");
        System.out.println();
    }
}
