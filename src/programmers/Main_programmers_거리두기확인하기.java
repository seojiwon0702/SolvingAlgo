package programmers;

public class Main_programmers_거리두기확인하기 {

    public static int[] solution(String[][] places) {
        int[] answer = {};
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
        for(int i : result)
            System.out.print(i + " ");
        System.out.println();
    }
}
