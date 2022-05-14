package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_boj_1238_파티{
	
	static final int INF = Integer.MAX_VALUE;
	static long[][] map = null;
	static long[][] minDis = null;
	static boolean[][] isChecked = null;
	static int N, M, X;
	
	private static void initArr(long[][] arr) {
		for(int i=0; i<=N; i++)
			Arrays.fill(arr[i], INF);
		
		for(int i=0; i<=N; i++) {
			arr[i][i] = 0;
		}
	}
	
	private static int getMinIdx(int start) {
		int idx = 0;
		long T = INF;
		
		for(int i=1; i<=N; i++) {
			if(!isChecked[start][i] && minDis[start][i]<T) {
				idx = i;
				T = minDis[start][i];
			}
		}
		
		return idx;
	}
	
	private static void dijkstra(int start) {
		for(int i=0; i<N-1; i++) {
			int minIdx = getMinIdx(start);
			isChecked[start][minIdx] = true;
			for(int j=1; j<=N; j++) {
				if(start==j) continue;
				if(!isChecked[start][j] && minDis[start][j] > minDis[start][minIdx]+map[minIdx][j]) {
					minDis[start][j] = minDis[start][minIdx]+minDis[minIdx][j];
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		map = new long[N+1][N+1];
		minDis = new long[N+1][N+1];
		
		initArr(map);
		initArr(minDis);
		isChecked = new boolean[N+1][N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			long time = Integer.parseInt(st.nextToken());
			map[start][end] = time;
			minDis[start][end] = time;
		}
		
		for(int i=1; i<=N; i++) {
			dijkstra(i);
		}
		
		long answer = 0;
		for(int i=1; i<=N; i++) {
			if(answer < minDis[i][X] + minDis[X][i])
				answer = minDis[i][X] + minDis[X][i];
		}
		
		System.out.println(answer);
	}

}
