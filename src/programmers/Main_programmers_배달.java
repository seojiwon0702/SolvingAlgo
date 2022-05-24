package programmers;

import java.util.Arrays;

public class Main_programmers_배달 {
    public static int[] distance;
    public static int[][] map;

    private static void dfs(int bridge, int preValue, int k){
        for(int i=0; i<distance.length; i++){
            if(bridge==i || map[bridge][i]==Integer.MAX_VALUE) continue;
            if(distance[i] > preValue + map[bridge][i]) {
                distance[i] = preValue + map[bridge][i];
                if(distance[i]<k)
                    dfs(i, distance[i], k);
            }

        }
    }

    public static int solution(int N, int[][] road, int K) {
        int answer = 0;
        distance = new int[N];
        Arrays.fill(distance, Integer.MAX_VALUE);

        map = new int[N][N];
        for(int i=0; i<map.length; i++)
            Arrays.fill(map[i], Integer.MAX_VALUE);

        for(int i=0; i<road.length; i++){
            if(map[road[i][0]-1][road[i][1]-1] > road[i][2]) {
                map[road[i][0] - 1][road[i][1] - 1] = road[i][2];
                map[road[i][1] - 1][road[i][0] - 1] = road[i][2];
            }
        }
        for(int i=0; i<N; i++) {
            map[i][i] = 0;
            if(map[0][i]!= Integer.MAX_VALUE)
                distance[i] = map[0][i];
        }

        for(int i=1; i<N; i++){
            if(distance[i]<K){
                dfs(i, distance[i], K);
            }
        }

        for(int i=0; i<distance.length; i++) {
            if (distance[i] <= K)
                answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int N = 6;
        int[][] road = {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};
        int K = 4;
        int result = solution(N, road, K);
        System.out.println(result);
    }
}
