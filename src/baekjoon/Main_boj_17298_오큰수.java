package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_boj_17298_오큰수{
	
	static Num[] nums = null;
	static int[] answer = null;
	
	private static void func() {
		Stack<Num> stack = new Stack<Num>();
		stack.push(nums[0]);
		answer[0] = -1;
		
		for(int i=1; i<nums.length; i++) {
			while(stack.size()>0 && nums[i].value>stack.peek().value) {
				answer[stack.peek().idx] = nums[i].value;
				stack.pop();
			}
			stack.push(nums[i]);
			answer[nums[i].idx] = -1;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		nums = new Num[N];
		answer = new int[N];
		
		for(int i=0; i<N; i++)
			nums[i] = new Num(Integer.parseInt(st.nextToken()),i);
		
		func();
		
		for(int i=0; i<N; i++)
			sb.append(answer[i]+" ");
		
		System.out.println(sb.toString());
	}
	
	static class Num {
		int value, idx;
		Num(int value, int idx){
			this.value = value;
			this.idx = idx;
		}
	}

}
