package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_boj_1389_케빈베이컨의6단계법칙 {
	
	static int[][] friends = null;
	static int N;
	
	private static void fw() {
		for(int i=0; i<N; i++) { // ����
			for(int j=0; j<N; j++) { // ���
				if(j==i) continue;
				for(int k=0; k<N; k++) { // ����
					if(k==i || k==j) continue;
					friends[j][k] = Math.min(friends[j][k], friends[j][i]+friends[i][k]);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		friends = new int[N][N];
		
		for(int i=0; i<N; i++) {
			Arrays.fill(friends[i], 1000000);
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			friends[a][b] = 1;
			friends[b][a] = 1;
		}
		
		fw();
		
		int numOfBacon = Integer.MAX_VALUE;
		int idx = -1;
		for(int i=0; i<N; i++) {
			int sum = 0;
			for(int j=0; j<N; j++) {
				if(i==j) continue;
				sum+=friends[i][j];
			}
			if(sum<numOfBacon) {
				numOfBacon = sum;
				idx = i;
			}
		}
		
		System.out.println(idx+1);
	}

}
