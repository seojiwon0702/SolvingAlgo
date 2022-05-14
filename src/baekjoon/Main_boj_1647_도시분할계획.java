package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_boj_1647_도시분할계획 {

    static int[] parent = null;
    static PriorityQueue<Node> pq = new PriorityQueue<Node>();

    private static void initParent(){
        for(int i=0; i<parent.length; i++){
            parent[i] = i;
        }
    }

    private static boolean union(int a, int b){
        int parentA = find(a);
        int parentB = find(b);
        if(parentA == parentB) return false;
        else parent[parentA] = parentB; return true;
    }

    private static int find(int a){
        if(parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }

    private static int kruskal(){
        Node node = pq.poll();
        union(node.start, node.end);

        int total = node.cost;
        int maxPrice = node.cost;

        while(!pq.isEmpty()){
            Node peek = pq.poll();
            if(union(peek.start, peek.end)){
                total += peek.cost;
                if(peek.cost>maxPrice)
                    maxPrice = peek.cost;
            }

        }

        return total - maxPrice;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 집의 개수
        int M = Integer.parseInt(st.nextToken()); // 길의 개수

        parent = new int[N+1];
        initParent();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            pq.offer(new Node(start, end, cost));
        }

        System.out.println(kruskal());
    }

    static class Node implements Comparable<Node>{
        int start, end, cost;

        Node(int start, int end, int cost){
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}
