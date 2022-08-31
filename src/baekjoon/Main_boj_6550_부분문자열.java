package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_boj_6550_부분문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        String str = null;
        while((str= br.readLine()) != null){
            st = new StringTokenizer(str);
            if(!st.hasMoreTokens()) break;

            String s = st.nextToken();
            String t = st.nextToken();

            boolean flag = true;
            for(int i=0; i<s.length(); i++){
                int idx = t.indexOf(s.charAt(i));
                if(idx==-1) {
                    flag = false;
                    break;
                }
                t = t.substring(idx+1);
            }
            sb.append(flag? "Yes" : "No").append("\n");
        }

        System.out.println(sb.toString());
    }
}
