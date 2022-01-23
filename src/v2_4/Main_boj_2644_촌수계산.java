package v2_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_boj_2644_촌수계산 {

    static boolean[][] family = null;
    static boolean[] isChecked = null;

    private static int bfs(int person1, int person2){
        int answer = -1;

        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{person1, 0});
        isChecked[person1] = true;

        while(!queue.isEmpty()){
            int current[] = queue.poll();
            if(current[0]==person2){
                answer = current[1];
                break;
            }
            for(int i=0; i<isChecked.length; i++){
                if(!isChecked[i] && family[current[0]][i]){
                    queue.offer(new int[]{i, current[1]+1});
                    isChecked[i] = true;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        family = new boolean[n][n];
        isChecked = new boolean[n];
        st = new StringTokenizer(br.readLine());
        int[] question = new int[]{Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1};

        int m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken())-1;
            int child = Integer.parseInt(st.nextToken())-1;
            family[parent][child] = true;
            family[child][parent] = true;
        }

        int answer = bfs(question[0], question[1]);
        System.out.println(answer);
    }

}
