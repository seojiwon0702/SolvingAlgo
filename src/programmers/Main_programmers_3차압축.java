package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class Main_programmers_3차압축 {

    public static int[] copyArr(ArrayList<Integer> result){
        int[] answer = new int[result.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = result.get(i);
        }
        return answer;
    }

    public static int[] solution(String msg) {
        ArrayList<String> dict = new ArrayList<>(Arrays.asList("A","B","C","D","E","F","G",
                "H","I","J","K","L","M","N","O","P",
                "Q","R","S","T","U","V","W","X","Y","Z"));
        ArrayList<Integer> result = new ArrayList<>();

        int idx = 0;
        while(idx<msg.length()){
            String temp = "";
            temp += msg.charAt(idx);
            while(dict.contains(temp)){
                idx++;
                if(idx<msg.length())
                    temp += msg.charAt(idx);
                else break;
            }
//            System.out.println(temp);
            if(!dict.contains(temp)){
                dict.add(temp);
                temp = temp.substring(0, temp.length()-1);
            }
            result.add(dict.indexOf(temp)+1);
        }

        int[] answer = copyArr(result);
        return answer;
    }

    public static void main(String[] args) {
        int[] answer = solution("TOBEORNOTTOBEORTOBEORNOT");
        for(int i : answer)
            System.out.print(i + " ");
    }
}
