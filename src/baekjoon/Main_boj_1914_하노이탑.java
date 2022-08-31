package baekjoon;

import java.math.BigInteger;
import java.util.Scanner;

public class Main_boj_1914_하노이탑 {
    static StringBuilder sb = new StringBuilder();

    static void hanoi(int N, char from, char mid, char to) {
        if (N == 1) {
            sb.append(from).append(" ").append(to).append("\n");
        } else {
            hanoi(N - 1, from, to, mid);
            sb.append(from).append(" ").append(to).append("\n");
            hanoi(N - 1, mid, from, to);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BigInteger result = new BigInteger("1");
        if (n == 1) System.out.println(1);
        else {
            for (int i = 0; i < n; i++) {
                result = result.multiply(new BigInteger("2"));
            }
            result = result.subtract(new BigInteger("1"));
            sb.append(result).append("\n");
            if (n <= 20) {
                hanoi(n, '1', '2', '3');
            }
        }
        System.out.println(sb.toString());
    }
}
