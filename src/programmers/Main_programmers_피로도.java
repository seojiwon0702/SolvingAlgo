package programmers;

public class Main_programmers_피로도 {
    static int answer;
    static boolean[] check;

    public static void recursive(int newK, int[][] dungeons, int count){
        if(answer<count) answer = count;
        for(int i=0; i<dungeons.length; i++){
            if(!check[i] && dungeons[i][0]<=newK){
                check[i] = true;
                recursive(newK-dungeons[i][1], dungeons, count+1);
                check[i] = false;
            }
        }
    }

    public static int solution(int k, int[][] dungeons) {
        check = new boolean[dungeons.length];

        recursive(k, dungeons, 0);

        return answer;
    }

    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80,20},{50,40},{30,10}};
        System.out.println(solution(k, dungeons));
    }
}
