package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_boj_17608_막대기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] block = new int[n];

        for(int i=0; i<n; i++){
            block[i] = Integer.parseInt(br.readLine());
        }

        int answer = 1;
        int biggest = block[n-1];

        for(int i=n-2; i>=0; i--){
            if(biggest<block[i]){
                answer++;
                biggest = block[i];
            }
        }

        System.out.println(answer);
    }
}
