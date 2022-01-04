package v2_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_boj_16234_인구이동 {
	
	static int N,L,R;
	static int[][] map = null;
	static boolean[][] isVisited = null;
	static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
	
	private static boolean bfs(int r, int c) {
		int population = 0;
		Queue<int[]> queue = new LinkedList<int[]>();
		Queue<int[]> nations = new LinkedList<int[]>();
		
		isVisited[r][c] = true;
		queue.offer(new int[] {r,c});
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			population += map[current[0]][current[1]];
			nations.offer(current);
			for(int i=0; i<4; i++) {
				int nr = current[0] + deltas[i][0];
				int nc = current[1] + deltas[i][1];
				if(nr>=0 && nc>=0 && nr<N && nc<N && !isVisited[nr][nc]) {
					int m = Math.abs(map[current[0]][current[1]]-map[nr][nc]);
					if(m>=L && m<=R) {
						isVisited[nr][nc] = true;
						queue.offer(new int[] {nr,nc});
					}
				}
			}
		}
		
		int nationsSize = nations.size();
		
		if(nations.size()>1) {
			int resultPop = population/nations.size();
			while(!nations.isEmpty()) {
				int[] nation = nations.poll();
				map[nation[0]][nation[1]] = resultPop;
			}
			return true;
		}
		return false;
	}

	private static int func() {
		int answer = 0;
		boolean flag = true;
		
		while(flag) {
			flag = false;
			isVisited = new boolean[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!isVisited[i][j]) {
						if(bfs(i, j))
							flag = true;
					}
				}
			}
			if(flag) answer++;
		}
		
		return answer;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken()); // L~R
		
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(func());
	}

}
