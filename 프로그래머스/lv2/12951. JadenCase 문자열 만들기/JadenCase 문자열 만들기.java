class Solution {
    public String solution(String s) {
        String answer = "";
        boolean flag = true;
        for(String str : s.toLowerCase().split("")){
            if(flag){
                answer += str.toUpperCase();
                flag = false;
            }else{
                answer += str;
            }

            if(str.equals(" ")){
                flag = true;
            }
        }
        return answer;
    }
}