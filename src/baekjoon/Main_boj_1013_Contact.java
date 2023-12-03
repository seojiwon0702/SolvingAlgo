package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_boj_1013_Contact {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        for(int t=0; t<T; t++){
            String s = br.readLine();
            if(s.matches("(100+1+|01)+"))
                sb.append("YES\n");
            else sb.append("NO\n");
        }

        System.out.println(sb.toString());
    }
}
