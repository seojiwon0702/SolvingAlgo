package week_17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_boj_1916_최소비용구하기 {
	
	static int N;
	static int[][] map = null;
	static boolean[] result = null;
	
	private static void func(int start) {
		while(true) {
			int[] target = {0, 100000};
			for(int i=1; i<=N; i++) {
				if(i==start) continue;
				if(!result[i] && map[start][i]<target[1])
					target = new int[]{i, map[start][i]};
			}
			
			if(target[0] == 0) return;
			
			result[target[0]] = true;
			for(int i=1; i<=N; i++) {
				if(i==start) continue;
				if(map[start][i] > map[start][target[0]]+map[target[0]][i]) {
					map[start][i] = map[start][target[0]]+map[target[0]][i];
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine()); // 도시의 개수
		int M = Integer.parseInt(br.readLine()); // 버스의 개수
		
		result = new boolean[N+1];
		map = new int[N+1][N+1];
		for(int i=0; i<=N; i++) {
			Arrays.fill(map[i], 100000);
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			map[start][end] = value;
		}
		
		st = new StringTokenizer(br.readLine());
		int startPoint = Integer.parseInt(st.nextToken());
		int endPoint = Integer.parseInt(st.nextToken());
		func(startPoint);
		
		System.out.println(map[startPoint][endPoint]);
	}
}
