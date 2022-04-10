package programmers;

import java.util.Arrays;
import java.util.Locale;

public class Main_programmers_파일명정렬 {
    public static String[] solution(String[] files) {
        String[] answer = new String[files.length];
        FileName[] fileNames = new FileName[files.length];

        for(int i=0; i<fileNames.length; i++)
            fileNames[i] = new FileName(files[i]);

        Arrays.sort(fileNames);

        for(int i=0; i<files.length; i++)
            answer[i] = fileNames[i].fileName;
        return answer;
    }

    public static void main(String[] args) {
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        String[] answer = solution(files);
        for (String s : answer)
            System.out.print(s + " / ");
    }

    static class FileName implements Comparable<FileName>{
        String head;
        int num;
        String fileName;

        FileName(String fileName){
            this.fileName = fileName;
            this.num = 0;
            this.head = fileName.split("[0-9]")[0];
            for(int i=head.length(); i<fileName.length(); i++){
                if(fileName.charAt(i)>='0' && fileName.charAt(i)<='9'){
                    num*=10;
                    num+=Integer.parseInt(String.valueOf(fileName.charAt(i)));
                } else break;
            }
            System.out.println(this.fileName+" : "+this.head+" / "+this.num);
        }

        @Override
        public int compareTo(FileName o) {
            String thisHead = this.head.toLowerCase();
            String oHead = o.head.toLowerCase();
            int result = thisHead.compareTo(oHead);
            if(result == 0){
                return this.num - o.num;
            } else return result;
        }
    }
}
