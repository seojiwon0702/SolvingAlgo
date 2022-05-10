package programmers;

public class Main_programmers_쿼드압축후개수세기 {
    static int[] answer = new int[2];
    public static boolean check(int r, int c, int size, int[][] arr){
        for(int i=r; i<r+size; i++){
            for(int j=c; j<c+size; j++){
                if(arr[r][c] != arr[i][j])
                    return false;
            }
        }
        return true;
    }

    public static void func(int r, int c, int size, int[][] arr){
        if(check(r,c,size,arr)){
            answer[arr[r][c]]++;
        } else{
            func(r,c,size/2, arr); //좌상
            func(r, c+(size/2), size/2, arr); //우상
            func(r+(size/2), c, size/2, arr); //좌하
            func(r+(size/2), c+(size/2), size/2, arr); //우하
        }
    }

    public static int[] solution(int[][] arr) {
        int size = arr.length;
        func(0,0,size,arr);
        return answer;
    }

    public static void main(String[] args) {
       int[][] arr = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
        int[] answer = solution(arr);
        System.out.println(answer[0] + " " + answer[1]);
    }
}
