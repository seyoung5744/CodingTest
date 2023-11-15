public class Solution {


    public static String solution(String m, String[] musicInfos) {
        String answer = "(None)";

        m = replaceSharp(m);

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < musicInfos.length; i++) {
            String[] tokens = musicInfos[i].split(",");
            int totalMin = toMin(tokens[1]) - toMin(tokens[0]);
            String title = tokens[2];
            String musicInfo = totalMusicInfo(totalMin, replaceSharp(tokens[3]));

            if (musicInfo.contains(m)) {
                if (totalMin > max) {
                    answer = title;
                    max = totalMin;
                }
            }
        }
        return answer;
    }

    public static String replaceSharp(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '#') {
                sb.replace(sb.length() - 1, sb.length(), String.valueOf(str.charAt(i - 1)).toLowerCase());
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static int toMin(String times) {
        String[] tokens = times.split(":");
        return Integer.parseInt(tokens[0]) * 60 + Integer.parseInt(tokens[1]);
    }

    public static String totalMusicInfo(int totalMin, String musicInfo) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < totalMin; i++) {
            sb.append(musicInfo.charAt(i % musicInfo.length()));
        }
        return sb.toString();
    }
}
