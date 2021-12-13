package mockTest_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_boj_2170_¼±±ß±â {
	
	static Queue<Line> queue = new PriorityQueue<Line>();
	
	private static int func() {
		int start, end;
		Line current = queue.poll();
		start = current.start;
		end = current.end;
		int result = Math.abs(start-end);
		while(!queue.isEmpty()) {
			current = queue.poll();
			if(current.start > end) {
				result += Math.abs(current.start-current.end);
				start = current.start;
				end = current.end;
			} else {
				if(end<current.end) {
					result+= Math.abs(current.end - end);
					end = current.end;
				}
			}
		}
		
		return result;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			queue.offer(new Line(start, end));
		}
		
		System.out.println(func());
		
	}
	
	static class Line implements Comparable<Line> {
		int start, end;
		Line(int start, int end){
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Line o) {
			if(this.start!=o.start) {
				return Integer.compare(this.start, o.start);
			} else {
				return Integer.compare(this.end, o.end);
			}
		}
		
	}

}