package v2_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_boj_1182_부분수열의합 {
	
	static int[] numbers = null;
	static int N, S, answer = 0;
	
	private static void func(int idx, int sum) {
		if(idx>=N) return;
		if(sum+numbers[idx] == S) answer++;
		
		func(idx+1, sum);
		func(idx+1, sum+numbers[idx]);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 정수의 개수
		S = Integer.parseInt(st.nextToken()); // 목표 정수
		
		numbers = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		func(0,0);
		
		System.out.println(answer);
		
	}

}
