package mockTest_5;

import java.util.Scanner;

public class Main_boj_2885_초콜릿식사 {
	
	static int originSize = 2;
	static int cut = 0;
	
	private static void cutting(int size, int k) {
		while(k!=0) {
			cut++;
			size/=2;
			if(k>=size)
				k-=size;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		sc.close();
		
		while(K > originSize) { originSize*=2; }
		
		if(K != originSize) cutting(originSize, K);
		
		System.out.println(originSize+" "+cut);
	}

}