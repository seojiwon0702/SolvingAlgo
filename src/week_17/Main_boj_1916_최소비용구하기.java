package week_17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_boj_1916_최소비용구하기 {
	
	static final int INF = Integer.MAX_VALUE;
	static long[][] map = null;
	static boolean[] isChecked = null;
	
	private static int getMinIdx(int start, int N) {
		int idx = 0;
		int minVal = INF;
		for(int i=1; i<=N; i++) {
			if(start == i) continue;
			if(!isChecked[i] && minVal>map[start][i]) {
				idx = i;
				minVal = (int)map[start][i];
			}
		}
		return idx;
	}
	
	private static void dijkstra(int start, int N) {
		for(int i=0; i<N-1; i++) {
			int minIdx = getMinIdx(start, N);
			isChecked[minIdx] = true;
			for(int j=1; j<=N; j++) {
				if(start==j) continue;
				if(!isChecked[j] && map[start][j] > map[start][minIdx]+map[minIdx][j]) {
					map[start][j] = map[start][minIdx]+map[minIdx][j];
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		map = new long[N+1][N+1];
		isChecked = new boolean[N+1];
		
		for(int i=0; i<=N; i++) {
			Arrays.fill(map[i], INF);
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			if(map[start][end] > value)
				map[start][end] = value;
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		dijkstra(start, N);
		
		System.out.println(map[start][end]);
	}
}
