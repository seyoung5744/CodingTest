class Solution {
    public int solution(String s) {
        int answer = s.length();

        for (int step = 1; step < s.length() / 2 + 1; step++) {
            String compressed = "";
            String pre = s.substring(0, step);
            int cnt = 1;


            for (int i = step; i < s.length(); i += step) {
                String sub = "";

                for (int j = i; j < i + step; j++) {
                    if(j < s.length()) sub += s.charAt(j);
                }

                if(pre.equals(sub)) cnt += 1;
                else{
                    compressed += (cnt >= 2)? cnt + pre : pre;

                    pre = sub; // 다시 상태 초기화
                    cnt = 1;
                }
            }

            compressed += (cnt >= 2)? cnt + pre : pre;
            answer = Math.min(answer, compressed.length());
        }
        
        return answer;
    }
}