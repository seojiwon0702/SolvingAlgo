package programmers;

import java.util.StringTokenizer;

public class Main_programmers_방금그곡 {
    public static boolean isContain(String a, String b){
        boolean result = false;
        boolean flag = false;
        for(int i=0; i<b.length(); i++){
            for(int j=0; j<a.length(); j++){
                if(a.charAt(i) == b.charAt(j)){
                    i++;

                } else {
                    i=0;
                    flag = false;
                }
            }
            if(flag && i==b.length())
                result = true;
            break;
        }
        return result;
    }

    public static String solution(String m, String[] musicinfos) {
        Music[] musics = new Music[musicinfos.length];
        for(int i=0; i< musics.length; i++){
            musics[i] = new Music(musicinfos[i]);
        }

        Music answer = null;

        for(Music music : musics){
//            if(music.playCode.contains(m)){
            if(isContain(music.playCode, m)){
                if (answer == null)
                    answer = music;
                else
                    if(answer.playTime< music.playTime)
                        answer = music;
            }
        }

//        for(Music music : musics)
//            System.out.println(music.title + " : "+music.code +" / "+music.playTime+" / "+music.playCode);

        return answer==null?"(None)" : answer.title;
    }

    public static void main(String[] args) {
        String m = "ABC";
        String[] musicinfos = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        System.out.println(solution(m, musicinfos));
    }

    static class Music {
        int playTime;
        String playCode;
        String title;
        String code;

        Music(String musicInfo){
            StringTokenizer st = new StringTokenizer(musicInfo, ",");
            String startTime = st.nextToken();
            String endTime = st.nextToken();
            this.title = st.nextToken();
            this.code = st.nextToken();
            st = new StringTokenizer(startTime, ":");
            String startH = st.nextToken();
            String startM = st.nextToken();
            st = new StringTokenizer(endTime, ":");
            String endH = st.nextToken();
            String endM = st.nextToken();
            this.playTime = 0;
            this.playTime += (Integer.parseInt(endH) - Integer.parseInt(startH))*60;
            this.playTime += (Integer.parseInt(endM) - Integer.parseInt(startM));
            int idx = 0;
            int codeIdx = 0;
            this.playCode = "";
            while(codeIdx<playTime){
                if(code.charAt(idx%code.length())!='#'){
                    playCode += code.charAt(idx++%code.length());
                } else {
                    playCode += code.charAt(idx++%code.length());
                    playCode += code.charAt(idx++%code.length());
                }
                codeIdx++;
            }
        }
    }
}
