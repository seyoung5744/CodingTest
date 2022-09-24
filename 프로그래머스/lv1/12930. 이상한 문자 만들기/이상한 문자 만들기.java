class Solution {
    public String solution(String s) {
        String answer = "";
        String[] chars = s.split("");

        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            if(chars[i].equals(" ")){
                idx=0;
                answer += " ";
            }else {
                answer += (idx % 2 == 0)? chars[i].toUpperCase(): chars[i].toLowerCase();
                idx++;
            }
        }
        return answer;
    }
}