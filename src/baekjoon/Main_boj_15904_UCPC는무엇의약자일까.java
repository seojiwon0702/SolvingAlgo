package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_boj_15904_UCPC는무엇의약자일까 {
    public static boolean solution(String input){
        boolean result = true;
        int idx = input.indexOf("U");
        if(idx!=-1){
            input = input.substring(idx);
            idx = input.indexOf("C");
            if(idx!=-1){
                input = input.substring(idx);
                idx = input.indexOf("P");
                if(idx!=-1){
                    input = input.substring(idx);
                    idx = input.indexOf("C");
                    if(idx==-1){
                        result = false;
                    }
                } else result = false;
            } else result = false;
        } else result = false;

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        boolean result = solution(input);
        System.out.println(result?"I love UCPC":"I hate UCPC");
    }
}
