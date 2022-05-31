package programmers;

public class Main_programmers_불량사용자 {
    static int answer = 0;
    static boolean[] isChecked = new boolean[256];

    private static boolean isSame(String user_id, String banned_id) {
        if (user_id.length() != banned_id.length()) return false;
        else {
            for (int i = 0; i < user_id.length(); i++) {
                if (banned_id.charAt(i) == '*') continue;
                else if (banned_id.charAt(i) != user_id.charAt(i)) return false;
            }
        }
        return true;
    }

    // index : banned_id index
    // flag : user_id check using
    private static void recursive(String[] user_id, String[] banned_id, int index, int flag) {
        if (index == banned_id.length) {
            if(!isChecked[flag]){
                isChecked[flag] = true;
                answer++;
            }
            return;
        }
        for (int i = 0; i < user_id.length; i++) {
            if ((flag & 1 << i) != 0) continue;
            if (isSame(user_id[i], banned_id[index])) {
                recursive(user_id, banned_id, index + 1, flag | 1 << i);
            }
        }
    }

    public static int solution(String[] user_id, String[] banned_id) {
        recursive(user_id, banned_id, 0, 0);

        return answer;
    }

    public static void main(String[] args) {
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"*rodo", "*rodo", "******"};
        System.out.println(solution(user_id, banned_id));
    }
}
