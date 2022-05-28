package programmers;

import java.util.ArrayList;

public class Main_programmers_영어끝말잇기 {
    private static int[] solution(int n, String[] words){
        ArrayList<String> wordResult = new ArrayList<>();
        int cycle = 1;
        int idx = 1;
        String preWord = null;

        for(int i=0; i<words.length; i++){
            if(idx>n){
                idx=1;
                cycle++;
            }
            if(wordResult.indexOf(words[i])==-1){
                if(preWord != null && preWord.charAt(preWord.length()-1)!=words[i].charAt(0))
                    return new int[]{idx, cycle};;
                preWord = words[i];
                wordResult.add(words[i]);
                idx++;
            } else{
                return new int[]{idx, cycle};
            }
        }

        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        int n = 2;
        String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
        int[] result = solution(n, words);
        for(int i : result){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
