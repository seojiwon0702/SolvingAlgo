package programmers;

public class Main_programmers_네트워크 {
    public static int[] parents;

    public static void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        if (parentA == parentB) return;
        else parents[parentB] = parentA;
    }

    public static int find(int a) {
        if (parents[a] == a) return a;
        else return parents[a] = find(parents[a]);
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;

        parents = new int[n];
        for (int i = 0; i < n; i++)
            parents[i] = i;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        boolean[] isChecked = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!isChecked[find(i)]) {
                isChecked[find(i)] = true;
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(solution(n, computers));
    }
}
