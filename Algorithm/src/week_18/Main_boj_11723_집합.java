package week_18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_boj_11723_집합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int M = Integer.parseInt(br.readLine());
		
		int arrays = 0;
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			
			// add
			if(command.compareTo("add")==0) {
				int n = Integer.parseInt(st.nextToken());
				arrays = arrays|1<<n;
			}
			// remove
			if(command.compareTo("remove")==0) {
				int n = Integer.parseInt(st.nextToken());
				if((arrays&1<<n)!=0)
					arrays = arrays^1<<n;
			}
			// check
			if(command.compareTo("check")==0) {
				int n = Integer.parseInt(st.nextToken());
				sb.append((arrays&1<<n)!=0?1:0).append("\n");
			}
			// toggle
			if(command.compareTo("toggle")==0) {
				int n = Integer.parseInt(st.nextToken());
				if((arrays&1<<n) == 0) {
					arrays = arrays|1<<n;
				} else {
					arrays = arrays^1<<n;
				}
			}
			// all
			if(command.compareTo("all")==0) {
				arrays = 2097150;
			}
			// empty
			if(command.compareTo("empty")==0) {
				arrays = 0;
			}
		}
		System.out.println(sb.toString());
	}

}
