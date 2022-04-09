package programmers;

import java.util.PriorityQueue;

public class Main_programmers_파일명정렬 {
    public static String[] solution(String[] files) {
        PriorityQueue<FileName> pq = new PriorityQueue<>();
        System.out.println("in");
        for (String file : files) {
            FileName fn = new FileName(file);
            pq.add(fn);
            System.out.println(fn.head+" / "+fn.num+" / "+fn.fileName);
        }

        int idx = 0;
        System.out.println("out");
        while (!pq.isEmpty()) {
            System.out.println(pq.peek().head+" / "+pq.peek().num+" / "+pq.peek().fileName);
            files[idx] = pq.poll().fileName;
            idx++;
        }

        return files;
    }

    public static void main(String[] args) {
        //"ABC12","AbC12","aBc12"
        //"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"
        String[] files = {"ABC12","AbC12","aBc12"};
        String[] answer = solution(files);
        for (String s : answer)
            System.out.print(s + " ");
    }

    static class FileName implements Comparable<FileName> {
        String fileName = "";
        String head = "";
        int num = 0;
        String tail = "";

        FileName(String filename) {
            fileName += filename;
            boolean headFlag = true;
            boolean numFlag = false;
            boolean tailFlag = true;
            int idx = 0;
            while (idx < filename.length()) {
                if (!numFlag && (int) filename.charAt(idx) >= 48 && (int) filename.charAt(idx) <= 57) {
                    headFlag = false;
                    numFlag = true;
                } else if (numFlag && ((int) filename.charAt(idx) < 48 || (int) filename.charAt(idx) > 57)) {
                    numFlag = false;
                    tailFlag = true;
                }

                if (headFlag) {
                    if ((int) filename.charAt(idx) >= 97 && (int) filename.charAt(idx) <= 122)
                        head += (char) ((int) filename.charAt(idx) - 32);
                    else head += filename.charAt(idx);
                } else if (numFlag)
                    num = (num * 10) + Integer.parseInt(String.valueOf(filename.charAt(idx)));
                else
                    tail += filename.charAt(idx);
                idx++;
            }
        }

        @Override
        public int compareTo(FileName o) {
            if (this.head.compareTo(o.head) == 0) {
//                if(this.num-o.num==0){
//                    return 1;
//                }
                return this.num-o.num;
            } else return this.head.compareTo(o.head);
        }
    }
}
