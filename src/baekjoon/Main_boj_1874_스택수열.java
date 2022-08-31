package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_boj_1874_스택수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        int last_num = 0;
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            if (m > last_num) {
                while (m > last_num) {
                    stack.push(++last_num);
                    sb.append("+").append("\n");
                }
                stack.pop();
                sb.append("-").append("\n");
            } else {
                if(stack.pop() != m) {
                    System.out.println("NO");
                    return;
                } else{
                    sb.append("-").append("\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}
