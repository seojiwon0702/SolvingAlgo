package v2_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_boj_5014_스타트링크 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int F = Integer.parseInt(st.nextToken()); // 총 건물의 층수
        int S = Integer.parseInt(st.nextToken()); // 현재 위치
        int G = Integer.parseInt(st.nextToken()); // 스타트링크 위치
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[] floors = new int[F+1];
        Arrays.fill(floors, Integer.MAX_VALUE);
        floors[S] = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(S);
        while(!queue.isEmpty()){
            int currentFloor = queue.poll();
            if(currentFloor == G) break;
            if(currentFloor+U <= F && floors[currentFloor]+1<floors[currentFloor+U]){
                floors[currentFloor+U] = floors[currentFloor]+1;
                queue.offer(currentFloor+U);
            }
            if(currentFloor-D > 0 && floors[currentFloor]+1<floors[currentFloor-D]){
                floors[currentFloor-D] = floors[currentFloor]+1;
                queue.offer(currentFloor-D);
            }
        }

        System.out.println(floors[G]==Integer.MAX_VALUE?"use the stairs":floors[G]);
    }
}
