package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 0 : 상하, 1 : 좌우
public class Main_programmers_경주로건설 {
    public static int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int N = board.length;
        int[][] deltas = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        int[][][] costs = new int[N][N][2];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0});
        queue.offer(new int[]{0, 0, 1});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            if (current[0] == N - 1 && current[1] == N - 1) {
                if (costs[N - 1][N - 1][current[2]] < answer)
                    answer = costs[N - 1][N - 1][current[2]];
                continue;
            }
            for (int d = 0; d < 4; d++) {
                int nr = current[0] + deltas[d][0];
                int nc = current[1] + deltas[d][1];
                int direction = current[2];
                int cost = costs[current[0]][current[1]][direction];

                if ((direction == 0 && (d == 0 || d == 2)) || (direction == 1 && (d == 1 || d == 3))) {
                    cost += 100;
                } else {
                    direction = (direction + 1) % 2;
                    cost += 600;
                }

                if (nr >= 0 && nc >= 0 && nr < N && nc < N && board[nr][nc] == 0 && (costs[nr][nc][direction] == 0 || costs[nr][nc][direction] >= cost)) {
                    costs[nr][nc][direction] = cost;
                    queue.offer(new int[]{nr, nc, direction});
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0, 0, 0, 0}, {1, 0, 1, 1, 1, 1, 1, 0}, {1, 0, 0, 1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 1, 1, 1}, {1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 0}, {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 1, 0}};

        System.out.println(solution(board));
    }
}
