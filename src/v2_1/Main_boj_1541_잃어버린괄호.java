package v2_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_boj_1541_잃어버린괄호 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(),"-");
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		int size = st.countTokens();
		for(int i=0; i<size; i++) {
			StringTokenizer plus = new StringTokenizer(st.nextToken(),"+");
			int psize = plus.countTokens();
			int sum = 0;
			for(int j=0; j<psize; j++) {
				sum += Integer.parseInt(plus.nextToken());
			}
			queue.offer(sum);
		}
		
		int answer = queue.poll();
		
		while(!queue.isEmpty()) {
			answer -= queue.poll();
		}
		
		System.out.println(answer);
	}

}
