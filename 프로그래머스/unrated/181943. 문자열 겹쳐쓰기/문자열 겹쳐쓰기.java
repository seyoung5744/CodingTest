class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        String sub = my_string.substring(0, s);
        int length = my_string.length() - sub.length();
        if(length <= overwrite_string.length()) {
            answer = sub + overwrite_string;
        }else{
            answer = sub + overwrite_string + my_string.substring(sub.length() + overwrite_string.length());
        }
        return answer;
    }
}