package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class Main_programmers_가장먼노드 {
    static int[] distance;
    static ArrayList<ArrayList<Integer>> vertex = new ArrayList<>();

    public static void getDistance(int start, int end, int value){
        if(distance[end]<=value) return;
        distance[end] = value;
        for(int i=0; i<vertex.get(end).size(); i++){
            if(vertex.get(end).get(i)==start || vertex.get(end).get(i)==end) continue;
            getDistance(end, vertex.get(end).get(i), value+1);
        }
    }

    public static int solution(int n, int[][] edge) {
        int answer = 0;
        int max_distance = 0;
        distance = new int[n];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;

        for(int i=0; i<n; i++){
            vertex.add(new ArrayList<>());
        }

        for(int i=0; i<edge.length; i++){
            vertex.get(edge[i][0]-1).add(edge[i][1]-1);
            vertex.get(edge[i][1]-1).add(edge[i][0]-1);
        }

        for(int i=0; i<vertex.get(0).size(); i++){
            getDistance(0, vertex.get(0).get(i), 1);
        }

        for(int i=1; i<n; i++){
            if(max_distance<distance[i]){
                max_distance=distance[i];
                answer=1;
            } else if(max_distance == distance[i]) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

        System.out.println(solution(n, edges));
    }
}
