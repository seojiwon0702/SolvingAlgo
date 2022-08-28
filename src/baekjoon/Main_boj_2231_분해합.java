package baekjoon;

import java.util.Scanner;

public class Main_boj_2231_분해합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int answer = 0;

        for(int i=N-1; i>=0; i--){
            int temp = i;
            int result = i;

            while(temp!=0){
                result += temp%10;
                temp/=10;
            }
            if(result == N) answer = i;
        }

        System.out.println(answer);
    }
}
