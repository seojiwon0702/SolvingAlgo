package programmers;

public class Main_programmers_거리두기확인하기 {
    static int[][] deltas = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static boolean checkInval(char[][] place, boolean[][] check, int r, int c, int dis){
        if(dis!=0 && dis<=2 && place[r][c]=='P') return false;

        for(int d=0; d<4; d++){
            int nr = r + deltas[d][0];
            int nc = c + deltas[d][1];
            if(nr>=0 && nc>=0 && nr<5 && nc<5 && !check[nr][nc] && place[nr][nc]!='X'){
                check[nr][nc] = true;
                boolean result = checkInval(place, check, nr, nc, dis+1);
                check[nr][nc] = false;
                if(!result) return false;
            }
        }

        return true;
    }

    // P:참석자 ,O:빈좌석, X:파티션
    public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            char[][] place = new char[5][5];
            boolean[][] check = new boolean[5][5];
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    place[j][k] = places[i][j].charAt(k);
                }
            }

            //참석자 확인
            outer:for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if(place[j][k] == 'P'){
                        check[j][k] = true;
                        if(!checkInval(place, check, j, k, 0)){
                            answer[i] = -1;
                            break outer;
                        }
                        check[j][k] = false;
                    } else continue;
                }
            }
            answer[i] = answer[i]==0? 1 : 0;
        }

        return answer;
    }

    public static void main(String[] args) {
        String[][] places = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };

        int[] result = solution(places);
        for (int i : result)
            System.out.print(i + " ");
        System.out.println();
    }
}
