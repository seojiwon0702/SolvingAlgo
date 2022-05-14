package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_boj_1946_신입사원{
	
	private static int func(PriorityQueue<Applicant> applicants, int N) {
		int answer = 0;
		int maxInterviewRank = N+1;
		
		while(!applicants.isEmpty()) {
			Applicant applicant = applicants.poll();
			if(applicant.interview<maxInterviewRank) {
				answer++;
				maxInterviewRank = applicant.interview;
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
			int N = Integer.parseInt(br.readLine());
			PriorityQueue<Applicant> applicants = new PriorityQueue<Applicant>();
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				int document = Integer.parseInt(st.nextToken());
				int interview = Integer.parseInt(st.nextToken());
				applicants.offer(new Applicant(document, interview));
			}
			
			sb.append(func(applicants, N)).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static class Applicant implements Comparable<Applicant>{
		int document, interview;
		Applicant(int document, int interview){
			this.document = document;
			this.interview = interview;
		}
		
		@Override
		public int compareTo(Applicant o) {
			return Integer.compare(this.document, o.document);
		}
	}

}
