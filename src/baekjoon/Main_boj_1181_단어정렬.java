package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_boj_1181_단어정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Word> words = new PriorityQueue<>();

        for(int i=0; i<N; i++)
            words.offer(new Word(br.readLine()));

        String temp = "";
        while(!words.isEmpty()){
            String poll = words.poll().word;
            if(!poll.equals(temp)) {
                sb.append(poll).append("\n");
                temp = poll;
            }
        }

        System.out.println(sb.toString());
    }

    static class Word implements Comparable<Word>{
        String word;
        Word(String word){
            this.word = word;
        }

        @Override
        public int compareTo(Word o) {
            if(this.word.length() == o.word.length()){
                return this.word.compareTo(o.word);
            } else
                return Integer.compare(this.word.length(), o.word.length());
        }
    }
}
