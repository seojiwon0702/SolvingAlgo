package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_boj_1002_터렛 {

    private static int getDistance(int x1, int y1, int x2, int y2) {
        return (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2);
    }

    private static int func(int[] big, int[] small) {
        int answer = 0;
        int distance = getDistance(big[0], big[1], small[0], small[1]);

        if(distance == 0)
            answer = big[2] == small[2]? -1:0;

        else if(distance == (big[2]+small[2])*(big[2]+small[2]) || distance == (big[2]-small[2])*(big[2]-small[2]))
            answer = 1;

        else if(distance > (big[2]+small[2])*(big[2]+small[2]) || distance < (big[2]-small[2])*(big[2]-small[2]))
            answer = 0;

        else if(distance < (big[2]+small[2])*(big[2]+small[2]))
            answer = 2;

        return answer;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            int answer = 0;
            int[] jo = new int[3];
            int[] baek = new int[3];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<3; i++) jo[i] = Integer.parseInt(st.nextToken());
            for(int i=0; i<3; i++) baek[i] = Integer.parseInt(st.nextToken());
            answer = (jo[2] >= baek[2]?func(jo,baek):func(baek, jo));

            sb.append(new String(answer + "\n"));
        }
        System.out.println(sb.toString());
    }

}