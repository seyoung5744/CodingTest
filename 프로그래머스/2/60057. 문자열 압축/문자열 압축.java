class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;

        for (int length = 1; length <= s.length() / 2 + 1; length++) {
            StringBuilder sb = new StringBuilder();
            String pre = "";
            int count = 1;
            for (int i = 0; i < s.length(); i += length) {
                String sub = (s.length() - i < length) ? s.substring(i) : s.substring(i, i + length);

                if (sub.equals(pre)) {
                    count++;
                } else {
                    if(count < 2) {
                        sb.append(pre);
                    }else {
                        sb.append(count).append(pre);
                    }
                    count = 1;
                }
                pre = sub;
            }

            if(count < 2) {
                sb.append(pre);
            }else {
                sb.append(count).append(pre);
            }
            answer = Math.min(sb.length(), answer);
        }

        return answer;
    }
}