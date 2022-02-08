package v2_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_boj_19238_스타트택시 {

    static int N, M, fuel;
    static int[][] map = null;
    static int[] taxi = null;
    static int[][] passenger = null;
    static boolean[] checkPassenger = null;
    static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};

    private static int getDistance(int r1, int c1, int r2, int c2){
        int distance = 0;

        int[][] dis = new int[map.length][map.length];
        Queue<int[]> q = new LinkedList<int[]>();
        q.offer(new int[]{r1,c1});

        for(int i=0; i<map.length; i++){
            Arrays.fill(dis[i],-1);
        }

        dis[r1][c1] = 0;

        while(!q.isEmpty()){
            int[] current = q.poll();
            for(int i=0; i<4; i++){
                int nr = current[0] + deltas[i][0];
                int nc = current[1] + deltas[i][1];
                if(nr>=0 && nc>=0 && nr<N && nc<N && dis[nr][nc]==-1 && map[nr][nc]==0){
                    dis[nr][nc] = dis[current[0]][current[1]]+1;
                    if(nr==r2 && nc==c2){
                        distance = dis[nr][nc];
                        return distance;
                    }
                    q.offer(new int[]{nr,nc});
                }
            }
        }


        return distance;
    }

    private static void func(){
        for(int i=0; i<M; i++){
            int closePassenger = -1;
            for(int j=0; j<M; j++){
                if(closePassenger==-1 && !checkPassenger[j]){
                    closePassenger = j;
                } else{
                    if(!checkPassenger[j] && getDistance(taxi[0], taxi[1],passenger[j][0],passenger[j][1])<getDistance(taxi[0], taxi[1],passenger[closePassenger][0], passenger[closePassenger][1])){
                        closePassenger = j;
                    }
                }
            }
            checkPassenger[closePassenger]=true;
            fuel -= getDistance(taxi[0], taxi[1],passenger[closePassenger][0], passenger[closePassenger][1]);
            int dis = getDistance(passenger[closePassenger][0], passenger[closePassenger][1],passenger[closePassenger][2], passenger[closePassenger][3]);
            fuel -= dis;
            if(fuel<0) {
                fuel = -1;
                return;
            }
            fuel += dis+dis;
            taxi = new int[]{passenger[closePassenger][2], passenger[closePassenger][3]};
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 지도 N X N
        M = Integer.parseInt(st.nextToken()); // 승객수
        fuel = Integer.parseInt(st.nextToken()); // 초기연료

        map = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        int taxiR = Integer.parseInt(st.nextToken())-1;
        int taxiC = Integer.parseInt(st.nextToken())-1;
        taxi = new int[]{taxiR, taxiC};

        passenger = new int[M][4];
        checkPassenger = new boolean[M];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int onr = Integer.parseInt(st.nextToken())-1;
            int onc = Integer.parseInt(st.nextToken())-1;
            int ofr = Integer.parseInt(st.nextToken())-1;
            int ofc = Integer.parseInt(st.nextToken())-1;
            passenger[i] = new int[]{onr, onc, ofr, ofc};
        }

        func();
        System.out.println(fuel);
    }
}
