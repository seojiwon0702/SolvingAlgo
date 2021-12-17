package week_18;

import java.util.Scanner;

public class Main_boj_1094_¸·´ë±â {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		sc.close();
		
		int stick = 64;
		int numOfParts = 0;
		int result = 0;
		
		if(X==64)
			numOfParts = 1;
		else {
			while(result!=X) {
				stick/=2;
				if(result+stick <= X) {
					result += stick;
					numOfParts++;
				}
			}
		}
		System.out.println(numOfParts);
	}

}
