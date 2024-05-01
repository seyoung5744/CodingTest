import java.util.Arrays;

public class Solution {

    public static String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxPlayTime = 0;

        m = convertMelody(m);
        // "12:00,12:14,HELLO,CDEFGAB"
        for (int i = 0; i < musicinfos.length; i++) {
            String[] tokens = musicinfos[i].split(",");
            int playTime = convertTime(tokens[1]) - convertTime(tokens[0]) + 1;

            String melo = convertMelody(tokens[3]);
            while (playTime > melo.length()) {
                melo += melo;
            }

            melo = melo.substring(0, playTime);

            if (melo.contains(m)) {
                if (playTime > maxPlayTime) {
                    maxPlayTime = playTime;
                    answer = tokens[2];
                }
            }
        }

        return answer;
    }

    private static int convertTime(String time) {
        int[] tokens = Arrays.stream(time.split(":")).mapToInt(Integer::parseInt).toArray();
        return tokens[0] * 60 + tokens[1];
    }

    private static String convertMelody(String m) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m.length(); ++i) {
            if (m.charAt(i) == '#') {
                sb.replace(sb.length() - 1, sb.length(), String.valueOf(m.charAt(i - 1)).toLowerCase());
                continue;
            }

            sb.append(m.charAt(i));
        }

        return sb.toString();
    }
}
