package programmers;

import java.util.PriorityQueue;

public class Main_programmers_섬연결하기 {

    static int[] islands;

    public static boolean union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        if(pa == pb) return false;
        islands[pb] = pa;
        return true;
    }

    public static int find(int a){
        if(islands[a] == a) return a;
        return islands[a] = find(islands[a]);
    }

    public static int solution(int n, int[][] costs){
        int answer = 0;

        islands = new int[n];
        for(int i=0; i<n; i++) islands[i] = i;

        PriorityQueue<Bridge> bridges = new PriorityQueue<>();
        for(int i=0; i<costs.length; i++)
            bridges.offer(new Bridge(costs[i][0], costs[i][1], costs[i][2]));

        while(!bridges.isEmpty()){
            Bridge bridge = bridges.poll();
            if(union(bridge.island1, bridge.island2))
                answer += bridge.cost;
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};

        int answer = solution(n, costs);
        System.out.println(answer);
    }

    static class Bridge implements Comparable<Bridge>{
        int island1;
        int island2;
        int cost;

        Bridge(int island1, int island2, int cost){
            this.island1 = island1;
            this.island2 = island2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Bridge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}
