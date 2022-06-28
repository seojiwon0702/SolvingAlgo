package programmers;

import java.util.ArrayList;

public class Main_programmers_프렌즈4블록 {
    public static boolean checkBlock(int r, int c, char[][] board) {
        char flag = board[r][c];
        if (flag == ' ') return false;
        if (flag == board[r + 1][c] && flag == board[r][c + 1] && flag == board[r + 1][c + 1]) {
            return true;
        }
        return false;
    }

    public static void downBlock(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = m - 1; j >= 0; j--) {
                if (board[j][i] == ' ') {
                    int k = j;
                    while (k >= 0 && board[k][i] == ' ') k--;
                    if (k >= 0) {
                        board[j][i] = board[k][i];
                        board[k][i] = ' ';
                    }
                }
            }
        }
    }

    public static int breakBlock(char[][] board) {
        int count = 0;
        int m = board.length;
        int n = board[0].length;
        ArrayList<Block> list = new ArrayList<>();

        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (checkBlock(i, j, board)) {
                    for (int k = 0; k < 2; k++) {
                        for (int l = 0; l < 2; l++) {
                            Block block = new Block(i + k, j + l);
                            if (!list.contains(block))
                                list.add(block);
                        }
                    }
                } else continue;
            }
        }

        count += list.size();
        for (int i = 0; i < list.size(); i++) {
            board[list.get(i).m][list.get(i).n] = ' ';
        }

        return count;
    }

    public static int solution(int m, int n, String[] board) {
        int answer = 0;

        char[][] arrBoard = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arrBoard[i][j] = board[i].charAt(j);
            }
        }

        while (true) {
            int result = breakBlock(arrBoard);
            if (result == 0) break;
            else {
                answer += result;
                downBlock(arrBoard);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        int m = 6;
        int n = 6;
        System.out.println(solution(m, n, board));
    }

    static class Block {
        int m, n;

        Block(int m, int n) {
            this.m = m;
            this.n = n;
        }

        @Override
        public boolean equals(Object o) {
            if (((Block) o).m == this.m && ((Block) o).n == n)
                return true;
            return false;
        }
    }
}
