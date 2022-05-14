package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_boj_2565_전깃줄 {
	
	static Wire[] wires = null;
	
	private static int LIS() {
		int[] memo = new int[wires.length];
		int lis = 1;
		
		for(int i=0; i<wires.length; i++) {
			memo[i] = 1;
			for(int j=0; j<i; j++) {
				if(wires[i].B>wires[j].B && memo[i] < memo[j]+1) {
					memo[i] = memo[j]+1;
					if(lis < memo[i])
						lis = memo[i];
				}
			}
		}
		
		return lis;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		wires = new Wire[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			wires[i] = new Wire(A,B);
		}
		
		Arrays.sort(wires);
		
		System.out.println(N-LIS());
	}
	
	static class Wire implements Comparable<Wire>{
		int A, B;
		Wire(int A, int B) {
			this.A = A;
			this.B = B;
		}
		@Override
		public int compareTo(Wire o) {
			return Integer.compare(this.A, o.A);
		}
	}
}
