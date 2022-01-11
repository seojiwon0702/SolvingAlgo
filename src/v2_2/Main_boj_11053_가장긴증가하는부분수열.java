package v2_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_boj_11053_가장긴증가하는부분수열 {
	
	static int[] nums = null;
	static int[] lis = null;
	
	private static int LIS() {
		int answer = 0;
		for(int i=0; i<nums.length; i++) {
			lis[i] = 1;
			for(int j=0; j<i; j++) {
				if(nums[i]>nums[j] && lis[i]< lis[j]+1) {
					lis[i] = lis[j]+1;
					if(lis[i]>answer)
						answer = lis[i];
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		nums = new int[N];
		lis = new int[N];
		
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(LIS());
	}

}
