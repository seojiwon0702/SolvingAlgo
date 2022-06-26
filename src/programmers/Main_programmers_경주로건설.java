package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_programmers_경주로건설 {

    public static int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int[][] deltas = {{-1,0}, {0,1}, {1,0},{0,-1}};
        int[][] cost = new int[board.length][board[0].length];
        for(int i=0; i<cost.length; i++){
            Arrays.fill(cost[i],Integer.MAX_VALUE);
        }
        cost[0][0] = 0;

        Queue<Block> queue = new LinkedList<>();
        queue.offer(new Block(0,0,-1));
        queue.offer(new Block(0,0,1));

        while(!queue.isEmpty()){
            Block block = queue.poll();
            if(block.r == board.length-1 && block.c == board[0].length-1 && answer>=cost[block.r][block.c])
                answer = cost[block.r][block.c];
            for(int d=0; d<4; d++){
                int nr = block.r + deltas[d][0];
                int nc = block.c + deltas[d][1];
                int price = cost[block.r][block.c];
                int direction = block.direction;
                if((direction==-1 && (d==0 || d==2)) || (direction==1 && (d==1 || d==3)))
                    price += 100;
                else{
                    price += 600;
                    direction *= -1;
                }
                if(nr>=0 && nc>=0 && nr< board.length && nc<board[0].length && board[nr][nc] == 0 && cost[nr][nc]>=price){
                    cost[nr][nc] = price;
                    queue.offer(new Block(nr, nc, direction));
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 1}, {0, 0, 1, 0, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 1, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0}};

        System.out.println(solution(board));
    }

    static class Block{
        int r,c,direction;

        Block(int r, int c, int direction){
            this.r = r;
            this.c = c;
            this.direction = direction;
        }
    }
}
