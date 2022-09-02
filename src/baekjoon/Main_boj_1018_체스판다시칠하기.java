package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_boj_1018_체스판다시칠하기 {
    static int answer = Integer.MAX_VALUE;
    static int[][] deltas = {{0,1},{1,0}};

    static char[][] copyArr(int r, int c, char[][] origin){
        char[][] newArr = new char[8][8];
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                newArr[i][j] = origin[r+i][c+j];
            }
        }
        return newArr;
    }

    static int countBlock(int r, int c, char[][] board){
        int count = 0;

        for(int i=0; i<2; i++){
            int nr = r + deltas[i][0];
            int nc = c + deltas[i][1];
            if(nr>=0 && nc>=0 && nr<8 && nc<8){
                if(board[nr][nc]==board[r][c]){
                    count++;
                    board[nr][nc] = board[r][c]=='W'?'B':'W';
                }
                count += countBlock(nr,nc,board);
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] board = new char[N][M];

        for(int n=0; n<N; n++){
            String row = br.readLine();
            for(int m=0; m<M; m++){
                board[n][m] = row.charAt(m);
            }
        }

        int row_limit = board.length - 8;
        int col_limit = board[0].length - 8;

        for(int r=0; r<=row_limit; r++){
            for(int c=0; c<=col_limit; c++){
                int answer_ori = countBlock(0,0, copyArr(r, c, board));

                char[][] chess_board = copyArr(r, c, board);
                chess_board[0][0] = chess_board[0][0] == 'W'?'B':'W';
                int answer_change = countBlock(0,0,chess_board) + 1;

                int answer_temp = answer_ori>answer_change? answer_change : answer_ori;
                if(answer_temp<answer) answer = answer_temp;
            }
        }

        System.out.println(answer);
    }
}
