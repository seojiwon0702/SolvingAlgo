package v2_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_boj_1182_�κм������� {
	
	static int[] numbers = null;
	static int N, S, answer = 0;
	
	private static void func(int idx, int sum) {
		if(sum>S) return;
		else {
			if(sum==S) answer++;
			if(idx<N) {
				func(idx+1, sum+numbers[idx]); // idx��° ���� �ִ� ���
				func(idx+1, sum); // idx��° ���� ���� �ʴ� ���
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // ������ ����
		S = Integer.parseInt(st.nextToken()); // ��ǥ ����
		
		numbers = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		func(0,0);
		
		System.out.println(answer);
		
	}

}
