public class Solution {

    public static String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        int playTime = convertTime(play_time);
        int advTime = convertTime(adv_time);

        int[] sums = new int[360_000];

        for (String log : logs) {
            String[] split = log.split("-");
            int start = convertTime(split[0]);
            int end = convertTime(split[1]);
            for (int i = start; i < end; i++) {
                sums[i] += 1;
            }
        }

        long initSum = 0;

        for (int i = 0; i <= advTime; i++) {
            initSum += sums[i];
        }
        answer = convertTime(0);
        long result = initSum;
        int left = 0;
        int right = advTime;
        while (right <= playTime) {
            initSum -= sums[left++];
            initSum += sums[right++];

            if (initSum > result) {
                result = initSum;
                answer = convertTime(left);
            }
        }
        return answer;
    }

    public static String convertTime(int time) {
        return String.format("%02d:%02d:%02d", (time / 60 / 60), (time / 60 % 60), (time % 60));
    }

    public static int convertTime(String time) {
        String[] tokens = time.split(":");
        return Integer.parseInt(tokens[0]) * 3600 + Integer.parseInt(tokens[1]) * 60 + Integer.parseInt(tokens[2]);
    }
}
