package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_boj_7562_나이트의이동{
	
	static int[][] deltas = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1,-2}, {-2, -1}};
	
	private static int func(int[] start, int[] dest, int I) {
		int[][] map = new int[I][I];
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(start);
		int answer = 0;
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			if(current[0]==dest[0] && current[1]==dest[1]) {
				answer = map[current[0]][current[1]];
				break;
			}
			for(int i=0; i<8; i++) {
				int nr = current[0] + deltas[i][0];
				int nc = current[1] + deltas[i][1];
				if(nr>=0 && nc>=0 && nr<I && nc<I && map[nr][nc]==0) {
					map[nr][nc] = map[current[0]][current[1]]+1;
					queue.offer(new int[] {nr,nc});
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			int I = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] start = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			st = new StringTokenizer(br.readLine());
			int[] dest = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			
			int answer = func(start, dest, I);
			sb.append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}

}
