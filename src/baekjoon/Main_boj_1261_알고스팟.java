package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_boj_1261_알고스팟{
	
	static int[][] map = null;
	static int[][] memo = null;
	static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
	
	private static void func() {
		memo[0][0] = 0;
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {0,0});
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			for(int i=0; i<4; i++) {
				int nr = current[0]+deltas[i][0];
				int nc = current[1]+deltas[i][1];
				if(nr>=0 && nr<map.length && nc>=0 && nc<map[0].length) {
					if(map[nr][nc]==1) { // ���̶��
						if(memo[nr][nc] > memo[current[0]][current[1]]+1) {
							memo[nr][nc] = memo[current[0]][current[1]]+1;
							queue.offer(new int[] {nr,nc});
						}
					} else { // ����̶��
						if(memo[nr][nc] > memo[current[0]][current[1]]) {
							memo[nr][nc] = memo[current[0]][current[1]];
							queue.offer(new int[] {nr,nc});
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		memo = new int[N][M];
		
		for(int i=0; i<N; i++) {
				Arrays.fill(memo[i], Integer.MAX_VALUE);
		}
		
		for(int i=0; i<N; i++) {
			String row = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = row.charAt(j)-'0';
			}
		}
		
		func();
		System.out.println(memo[N-1][M-1]);
	}

}
