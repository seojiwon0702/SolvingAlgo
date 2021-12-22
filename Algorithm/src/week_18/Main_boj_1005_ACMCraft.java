package week_18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_boj_1005_ACMCraft {
	
	static int[] D = null;
	static int[] pre = null;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Oper> pq = new PriorityQueue<Oper>();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 건물의 개수
			int K = Integer.parseInt(st.nextToken()); // 건설 규칙 개수
			D = new int[N+1]; // 건물당 걸리는 시간
			pre = new int[N+1];
			
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++) {
				D[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int pre = Integer.parseInt(st.nextToken());
				int post = Integer.parseInt(st.nextToken());
				pq.offer(new Oper(pre, post));
			}
			
			while(!pq.isEmpty()) {
				Oper current = pq.poll();
				if(pre[current.pre]==0) {
					pre[current.post] = current.pre;
					D[current.post] += D[current.pre];
				} else if(D[pre[current.post]] < D[current.pre]) {
					D[current.post] -= D[pre[current.post]];
					D[current.post] += D[current.pre];
					pre[current.post] = current.pre;
				}
			}
			
			int target = Integer.parseInt(br.readLine());
			sb.append(D[target]).append("\n");
		}
		System.out.println(sb.toString());
	}
	static class Oper implements Comparable<Oper>{
		int pre, post;
		Oper(int pre, int post){
			this.pre = pre;
			this.post = post;
		}
		@Override
		public int compareTo(Oper o) {
			if(this.post!=o.post)
				return Integer.compare(this.post, o.post);
			else
				return Integer.compare(this.pre, o.pre);
		}
	}
}
