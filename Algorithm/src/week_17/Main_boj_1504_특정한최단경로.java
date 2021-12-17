package week_17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_boj_1504_특정한최단경로 {
	
	static final int INF = Integer.MAX_VALUE;
	static int N, M;
	static long[][] map = null;
	static long[][] minDis = null;
	static boolean[][] isChecked = null;
	
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
		
		map = new long[N+1][N+1];
		minDis = new long[N+1][N+1];
		isChecked = new boolean[N+1][N+1];
		
		initArr(map);
		initArr(minDis);
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			map[start][end] = value;
			map[end][start] = value;
			minDis[start][end] = value;
			minDis[end][start] = value;
		}
		
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<=N; i++) {
			dijkstra(i);
		}
		
		long answer1 = minDis[1][v1] + minDis[v1][v2] + minDis[v2][N];
		long answer2 = minDis[1][v2] + minDis[v2][v1] + minDis[v1][N];
		
		long answer = answer1>answer2? answer2:answer1;
		
		System.out.println(answer>=INF? -1:answer);
	}

}
