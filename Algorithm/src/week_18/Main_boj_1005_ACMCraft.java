package week_18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_boj_1005_ACMCraft {
	
	static int[] D = null;
	static boolean[][] arr = null;
	static long[] memo = null;
	
	private static long func(int w) {
		if(memo[w]!=-1) return memo[w];
		else {
			long largeN = 0;
			for(int i=1; i<arr.length; i++) {
				if(arr[i][w]) {
					largeN = Math.max(largeN, func(i));
				}
			}
			return memo[w] = D[w]+largeN;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			int N, K;
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			D = new int[N+1];
			arr = new boolean[N+1][N+1];
			memo = new long[N+1];
			
			for(int i=0; i<=N; i++) {
				memo[i] = -1;
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++) {
				D[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int pre = Integer.parseInt(st.nextToken());
				int post = Integer.parseInt(st.nextToken());
				arr[pre][post] = true;
			}
			
			int W = Integer.parseInt(br.readLine());
			sb.append(func(W)).append("\n");
		}
		System.out.println(sb.toString());
	}
}
