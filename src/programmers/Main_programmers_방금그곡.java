package programmers;

import java.util.StringTokenizer;

public class Main_programmers_방금그곡 {

    public static String solution(String m, String[] musicinfos) {
        Music[] musics = new Music[musicinfos.length];
        for(int i=0; i< musics.length; i++){
            musicinfos[i] = musicinfos[i].replace("C#", "c");
            musicinfos[i] = musicinfos[i].replace("D#", "d");
            musicinfos[i] = musicinfos[i].replace("F#", "f");
            musicinfos[i] = musicinfos[i].replace("G#", "g");
            musicinfos[i] = musicinfos[i].replace("A#", "a");
            musics[i] = new Music(musicinfos[i]);
        }

        m = m.replace("C#","c");
        m = m.replace("D#","d");
        m = m.replace("F#","f");
        m = m.replace("G#","g");
        m = m.replace("A#","a");

        Music answer = null;

        for(Music music : musics){
            if(music.playCode.contains(m)){
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
