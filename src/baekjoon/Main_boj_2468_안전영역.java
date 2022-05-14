package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_boj_2468_안전영역 {

    static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
    static int[][] map = null;
    static boolean[][] isChecked = null;

    private static void bfs(int r, int c, int precipitation){
        Queue<int[]> q = new LinkedList<int[]>();
        isChecked[r][c] = true;
        q.offer(new int[]{r,c});
        while(!q.isEmpty()){
            int[] current = q.poll();
            for(int i=0; i<4; i++){
                int nr = current[0] + deltas[i][0];
                int nc = current[1] + deltas[i][1];
                if(nr>=0 && nc>=0 && nr<map.length && nc<map.length && !isChecked[nr][nc] && map[nr][nc]>precipitation){
                    isChecked[nr][nc] = true;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
    }

    private static int countArea(int precipitation){
        int result = 0;
        isChecked = new boolean[map.length][map.length];
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map.length; j++){
                if(!isChecked[i][j]&&map[i][j]>precipitation){
                    result++;
                    bfs(i, j, precipitation);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        int minHeight = 100;
        int maxHeight = 0;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                minHeight = minHeight>map[i][j]?map[i][j]:minHeight;
                maxHeight = maxHeight<map[i][j]?map[i][j]:maxHeight;
            }
        }
        int answer = 0;
        for(int i=minHeight-1; i<maxHeight; i++){
            int temp = countArea(i);
            answer = temp>answer?temp:answer;
        }
        System.out.println(answer);
    }
}
