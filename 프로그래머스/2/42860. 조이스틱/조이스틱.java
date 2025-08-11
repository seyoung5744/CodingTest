class Solution {
    public int solution(String name) {
        int answer = 0;
        int result = 0;

        for (int i = 0; i < name.length(); i++) {
            int pos = name.charAt(i) - 'A';
            if (pos <= 13) {
                result += pos;
            } else {
                result += 26 - pos;
            }
        }

        answer = name.length() - 1 + result;
        for (int i = 0; i < name.length(); ++i) {
            if (name.charAt(i) == 'A') {
                int end = i;

                while (end < name.length() && name.charAt(end) == 'A') {
                    ++end;
                }

                answer = Math.min(answer, Math.max(i - 1, 0) * 2 + name.length() - end + result);
                answer = Math.min(answer, (name.length() - end) * 2 + Math.max(i - 1, 0) + result);
                i = end - 1;
            }
        }
        return answer;
    }
}