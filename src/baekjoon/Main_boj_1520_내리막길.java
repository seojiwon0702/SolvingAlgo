package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_boj_1520_내리막길 {
    static int[][] map = null;
    static int[][] record = null;
    static int[][] deltas = {{-1,0}, {0,1}, {1,0}, {0,-1}};
    private static int function(int r, int c){
        if(record[r][c] != -1) return record[r][c];

        record[r][c] = 0;
        for(int i=0; i<4; i++){
            int nr = r+deltas[i][0];
            int nc = c+deltas[i][1];

            if(nr>=0 && nc>=0 && nr<map.length && nc<map[0].length && map[r][c]>map[nr][nc]){
                record[r][c] += function(nr,nc);
            }
        }
        return record[r][c];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        record = new int[m][n];

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                record[i][j] = -1;
            }
        }
        record[m-1][n-1] = 1;

        System.out.println(function(0,0));
    }
}
