package programmers;

public class Main_programmers_행렬의곱셈 {
    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for(int i=0; i<arr1.length; i++){
             for(int j=0; j<arr2[0].length; j++){
                 int sum = 0;
                 for(int k=0; k<arr1[0].length; k++){
                    int temp = arr1[i][k]*arr2[k][j];
                    sum += temp;
                 }
                 answer[i][j] = sum;
             }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
        int[][] arr2 = {{3, 3}, {3, 3}};
        int[][] answer = solution(arr1, arr2);

        for(int[] n : answer){
            for(int m : n){
                System.out.print(m + " ");
            }
            System.out.println();
        }
    }

}
